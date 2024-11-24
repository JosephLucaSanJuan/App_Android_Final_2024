package com.example.final_application_2024.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "factions")
data class FactionEntity(
    @PrimaryKey val id:Int = 0,
                val name:String = ""
)
