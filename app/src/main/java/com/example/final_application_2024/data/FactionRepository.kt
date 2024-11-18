package com.example.final_application_2024.data

import kotlinx.coroutines.flow.Flow

interface FactionRepository {
    suspend fun create()
    suspend fun update(faction:Faction)
    suspend fun delete(id:Int)
    suspend fun readAll():List<Faction>
    suspend fun readOne(id:Int):Faction
    fun observeAll(): Flow<List<Faction>>
}