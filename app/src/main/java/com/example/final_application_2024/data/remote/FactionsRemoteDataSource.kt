package com.example.final_application_2024.data.remote

import com.example.final_application_2024.data.Faction
import kotlinx.coroutines.flow.Flow

interface FactionsRemoteDataSource {
    suspend fun create(name: String):Result<Faction>
    suspend fun update(id: String, faction: Faction): Result<Faction>
    suspend fun delete(id: String)
    suspend fun readAll():List<Faction>
    suspend fun readOne(id: String): Faction
    fun observeAll(): Flow<List<Faction>>
}