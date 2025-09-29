package imp.sys.health.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadLogsWorker(appContext: Context, workerParams: WorkerParameters)
        : Worker(appContext, workerParams) {

        @SuppressLint("NewApi")
        override fun doWork(): Result {

            val videoUri  = inputData.keyValueMap.get("VURI") as String
            Log.d("HTX_WORK","Worker started : " + videoUri)
            val timestamp = inputData.keyValueMap.get("TS") as String
            try {
                val rate = getHeartRate(applicationContext, Uri.parse(videoUri), timestamp)
                Log.d("HTX_R2","Rate in main Act : "+rate)
                return Result.success()
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("HTX_R3","Failed : "+e)
                return Result.failure()
            }

            // Indicate whether the task done successfully 
            return Result.retry()
        }

    }