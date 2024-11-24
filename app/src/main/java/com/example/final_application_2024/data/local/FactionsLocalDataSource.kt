package com.example.final_application_2024.data.local

import com.example.final_application_2024.data.Faction
import kotlinx.coroutines.flow.Flow

interface FactionsLocalDataSource {
    suspend fun create(faction: Faction)
    suspend fun update(faction: Faction)
    suspend fun delete(faction: Faction)
    suspend fun readAll(): List<Faction>
    suspend fun readOne(id:Int): Faction
    fun observeAll(): Flow<List<Faction>>
}