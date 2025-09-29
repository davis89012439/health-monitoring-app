package imp.sys.health.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import imp.sys.health.database.HealthReportDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.min

@RequiresApi(Build.VERSION_CODES.P)
fun getHeartRate(context: Context, uri: Uri, timestamp: String): String {
    val MAX_FRAME_COUNT_CAP = 425
    val START_FRAME_INDEX = 10
    val FRAME_STEP = 15
    val ROI_X_START = 350
    val ROI_Y_START = 350
    val ROI_X_END_EXCL = 450
    val ROI_Y_END_EXCL = 450
    val PEAK_THRESHOLD = 3500
    // -------------------------------------

    val retriever = MediaMetadataRetriever()
    val frames = ArrayList<Bitmap>()

    try {

        retriever.setDataSource(context, uri)


        val countStr = retriever.extractMetadata(
            MediaMetadataRetriever.METADATA_KEY_VIDEO_FRAME_COUNT
        )
        val frameLimit = min(countStr?.toIntOrNull() ?: MAX_FRAME_COUNT_CAP, MAX_FRAME_COUNT_CAP)

        var i = START_FRAME_INDEX
        while (i < frameLimit) {
            retriever.getFrameAtIndex(i)?.let { frames.add(it) }
            i += FRAME_STEP
        }
    } catch (e: Exception) {
        Log.d("MediaPath", "setDataSource/query frames error: ${e.message}")
    } finally {
        try { retriever.release() } catch (_: Exception) {}
    }

    if (frames.isEmpty()) {
        GlobalScope.launch(Dispatchers.IO) {
            HealthReportDatabase.getHealthReportDatabase(context)
                .healthReportDao().updateHealthReport("0", timestamp)
        }
        return "0"
    }


    val a = mutableListOf<Long>()
    var pixelCount = 0L

    fun sumRoi(bmp: Bitmap): Long {

        val x0 = ROI_X_START.coerceAtLeast(0)
        val y0 = ROI_Y_START.coerceAtLeast(0)
        val x1 = ROI_X_END_EXCL.coerceAtMost(bmp.width)
        val y1 = ROI_Y_END_EXCL.coerceAtMost(bmp.height)

        var sum = 0L
        for (y in y0 until y1) {
            for (x in x0 until x1) {
                val c = bmp.getPixel(x, y)
                pixelCount++
                sum += Color.red(c) + Color.green(c) + Color.blue(c)
            }
        }
        return sum
    }

    for (bmp in frames) a.add(sumRoi(bmp))


    val b = mutableListOf<Long>()
    if (a.size >= 6) {
        for (k in 0 until (a.lastIndex - 5)) {
            val smoothed = (a[k] + a[k + 1] + a[k + 2] + a[k + 3] + a[k + 4]) / 4
            b.add(smoothed)
        }
    }

    if (b.isEmpty()) {
        GlobalScope.launch(Dispatchers.IO) {
            HealthReportDatabase.getHealthReportDatabase(context)
                .healthReportDao().updateHealthReport("0", timestamp)
        }
        return "0"
    }

    var prev = b.first()
    var count = 0
    for (idx in 1 until b.lastIndex) {
        val p = b[idx]
        if (p - prev > PEAK_THRESHOLD) count++
        prev = p
    }


    val bpm = (((count.toFloat()) * 60).toInt() / 4).toString()

    GlobalScope.launch(Dispatchers.IO) {
        try {
            HealthReportDatabase.getHealthReportDatabase(context)
                .healthReportDao().updateHealthReport(bpm, timestamp)
        } catch (e: Exception) {
            Log.e("HTX_R", "DB update error: $e")
        }
    }

    Log.d("HTX_R", "HR = $bpm")
    return bpm
}
