package com.example.final_application_2024.data.local.factions

import com.example.final_application_2024.data.Faction
import kotlinx.coroutines.flow.Flow

interface FactionsLocalDataSource {
    suspend fun create(faction: Faction)
    suspend fun update(id: String, faction: Faction)
    suspend fun delete(id: String)
    suspend fun readAll(): List<Faction>
    suspend fun readOne(id: String): Faction
    fun observeAll(): Flow<List<Faction>>
}