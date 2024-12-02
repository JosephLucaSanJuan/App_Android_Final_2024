package com.example.final_application_2024.data.local.factions

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "factions")
data class FactionEntity(
    @PrimaryKey val id:String = "",
                val name:String = ""
)
