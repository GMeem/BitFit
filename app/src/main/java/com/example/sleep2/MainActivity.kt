package com.example.sleep2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var sleeps: MutableList<Sleep>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sleepsRv = findViewById<RecyclerView>(R.id.sleepsRv)
        sleeps = mutableListOf()
        val adapter = SleepAdapter(sleeps)

        lifecycleScope.launch {
            (application as SleepApplication).db.sleepDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    Sleep(
                        entity.date,
                        entity.hours_slept,
                        entity.condition
                    )
                }.also { mappedList ->
                    sleeps.clear()
                    sleeps.addAll(mappedList)
                    adapter.notifyDataSetChanged()
                }
            }
        }

        sleepsRv.adapter = adapter
        sleepsRv.layoutManager = LinearLayoutManager(this)


        findViewById<Button>(R.id.createBtn).setOnClickListener{
            val intent = Intent(this@MainActivity, SleepEntryActivity::class.java)
            startActivity(intent)
        }
    }
}