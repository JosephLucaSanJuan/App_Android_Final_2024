package com.example.final_application_2024.data.local.transformers

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TransformersEntity::class], version = 1)
abstract class TransformersDatabase():RoomDatabase() {
    abstract fun transformersDao(): TransformersDao
}