package com.example.final_application_2024.data.local.factions

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.final_application_2024.data.local.FactionDao
import com.example.final_application_2024.data.local.FactionEntity

@Database(entities = [FactionEntity::class], version = 1)
abstract class FactionDatabase(): RoomDatabase() {
    abstract fun factionsDao(): FactionDao
}