package com.example.sleep2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SleepEntryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sleep_entry)

        findViewById<Button>(R.id.submitBtn).setOnClickListener{
            val sleepDate = findViewById<EditText>(R.id.dateInput).text.toString()
            val sleepHour = findViewById<EditText>(R.id.hourInput).text.toString()
            val sleepCondition = findViewById<EditText>(R.id.conditionInput).text.toString()

            lifecycleScope.launch(Dispatchers.IO) {
                (application as SleepApplication).db.sleepDao().insert(
                    SleepEntity(sleepDate,sleepHour,sleepCondition)
                )

            }
            finish()
        }
    }
}