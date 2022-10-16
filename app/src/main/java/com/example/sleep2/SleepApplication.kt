package com.example.sleep2

import android.app.Application

class SleepApplication : Application() {
    val db by lazy { AppDatabase.getInstance(this) }
}