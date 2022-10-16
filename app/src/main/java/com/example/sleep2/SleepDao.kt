package com.example.sleep2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface SleepDao {
    @Query("SELECT * FROM sleep_table")
    fun getAll(): Flow<List<SleepEntity>>

    @Insert
    fun insertAll(sleeps: List<SleepEntity>)

    @Insert
    fun insert(sleep: SleepEntity)
}