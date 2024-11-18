package com.example.final_application_2024.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.final_application_2024.data.Transformer

@Database(entities = [Transformer::class], version = 1)
abstract class TransformersDatabase():RoomDatabase() {
    abstract fun transformersDao():TransformersDao
}