package com.example.sleep2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sleep_table")
data class SleepEntity(

    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "hours_slept") val hours_slept: String,
    @ColumnInfo(name = "condition") val condition: String,
    @PrimaryKey(autoGenerate = true) val id: Long = 0,

)