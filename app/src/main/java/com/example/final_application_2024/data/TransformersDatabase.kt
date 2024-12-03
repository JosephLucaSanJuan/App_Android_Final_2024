package com.example.final_application_2024.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.final_application_2024.data.local.factions.FactionDao
import com.example.final_application_2024.data.local.factions.FactionEntity
import com.example.final_application_2024.data.local.transformers.TransformersDao
import com.example.final_application_2024.data.local.transformers.TransformersEntity

@Database(entities = [TransformersEntity::class,
                     FactionEntity::class], version = 1)
abstract class TransformersDatabase():RoomDatabase() {
    abstract fun transformersDao(): TransformersDao
    abstract fun factionDao(): FactionDao
}