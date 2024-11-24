package com.example.final_application_2024.data.local

import androidx.room.Database

@Database(entities = [FactionEntity::class], version = 1)
abstract class FactionDatabase {
    abstract fun factionsDao(): FactionDao
}