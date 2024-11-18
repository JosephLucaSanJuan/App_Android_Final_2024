package com.example.final_application_2024.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transformers")
data class TransformersEntity(
    @PrimaryKey val id:Int = 0,
                val name:String = "",
                val altMode:String = "",
                val gender:String = ""
)
