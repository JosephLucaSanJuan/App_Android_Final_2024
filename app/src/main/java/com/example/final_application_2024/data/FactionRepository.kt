package com.example.final_application_2024.data

import kotlinx.coroutines.flow.Flow

interface FactionRepository {
    suspend fun create(name:String): Result<Faction>
    suspend fun update(faction:Faction)
    suspend fun delete(faction:Faction)
    suspend fun readAll():List<Faction>
    suspend fun readOne(id:Int):Faction
    fun observeAll(): Flow<Result<List<Faction>>>
}