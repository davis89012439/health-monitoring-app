package imp.sys.health

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RatingBar
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import imp.sys.health.database.HealthReport
import imp.sys.health.database.HealthReportDatabase
import imp.sys.health.utils.HEART_RATE
import imp.sys.health.utils.RESPIRATORY_RATE
import imp.sys.health.utils.TIMESTAMP
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class UploadSymptomsActivity : AppCompatActivity() {

    private lateinit var spnrSymptomDropdown: Spinner
    private lateinit var rbSeverity: RatingBar
    private lateinit var btnSave: Button

    private var symptoms: MutableList<Float> = MutableList(10) {0.0f}

    private lateinit var healthReportDatabase: HealthReportDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_symptoms)

        spnrSymptomDropdown = findViewById(R.id.spnrSymptomDropdown)
        rbSeverity = findViewById(R.id.rbSeverity)
        btnSave = findViewById(R.id.btnSave)

        healthReportDatabase = HealthReportDatabase.getHealthReportDatabase(this)

        val heartRate = intent.getIntExtra(HEART_RATE,-1).toString()

        val ex  = intent.extras
        ex?.let { x ->
            for(k : String in x.keySet()){
                Log.d("HT_RT",k + " : "+ x.get(k))
            }
        }

        val respiratoryRate = intent.getIntExtra(RESPIRATORY_RATE,-1).toString()
        val timestamp = intent.getStringExtra(TIMESTAMP)

        Log.d("HT_RT","HR : "+heartRate)

        // Generative AI Used: ChatGPT (OpenAI, Sep 30, 2025)
        //Purpose: Use a simple ArrayAdapter to populate symptom names, then mirror the currently
        //          selected symptom’s last-seen severity into the RatingBar, and write back on change.
        //          This keeps a lightweight in-memory model (MutableList<Float>) without extra state.
        // Prompt: "Explain that Spinner selection drives RatingBar display (read), and RatingBar change
        //          writes back into the same index (write). Keep Android widget defaults; no custom view."
        ArrayAdapter.createFromResource(
            this,
            R.array.symptoms_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->  //spinner
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spnrSymptomDropdown.adapter = adapter
        }

        // Generative AI Used: ChatGPT (OpenAI, Sep 30, 2025)
        // Purpose: On selection, surface the stored severity for that symptom by setting rbSeverity.rating,
        //          providing immediate feedback and enabling quick per-symptom edits.
        // Prompt: "Add a brief note that item position maps 1:1 to symptoms[]; no extra mapping table needed."


        spnrSymptomDropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                rbSeverity.rating = symptoms[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
//                Not required
            }

        }

        rbSeverity.setOnRatingBarChangeListener{_, rating, _ ->
            symptoms[spnrSymptomDropdown.selectedItemPosition] = rating
        }

//        Save health report to database
        btnSave.setOnClickListener {
            val healthReport = HealthReport(
                timestamp,
                heartRate,
                respiratoryRate,
                nausea = symptoms[0].toString(),
                headache = symptoms[1].toString(),
                diarrhoea = symptoms[2].toString(),
                soarThroat = symptoms[3].toString(),
                fever = symptoms[4].toString(),
                muscleAche = symptoms[5].toString(),
                lossOfSmellOrTaste = symptoms[6].toString(),
                cough = symptoms[7].toString(),
                shortnessOfBreath = symptoms[8].toString(),
                feelingTired = symptoms[9].toString()
            )

            GlobalScope.launch(Dispatchers.IO) {
                healthReportDatabase.healthReportDao().insertHealthReport(healthReport)
            }

            Toast.makeText(this, "Your Health Report has been saved", Toast.LENGTH_LONG).show()

            val mainActivity = Intent(this, MainActivity::class.java)
            startActivity(mainActivity)
        }

    }
}