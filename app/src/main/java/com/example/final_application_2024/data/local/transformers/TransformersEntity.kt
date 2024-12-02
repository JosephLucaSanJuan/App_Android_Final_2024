package com.example.final_application_2024.data.local.transformers

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transformers")
data class TransformersEntity(
    @PrimaryKey val id:String = "",
                val name:String = "",
                val altMode:String = "",
                val gender:String = ""
)
