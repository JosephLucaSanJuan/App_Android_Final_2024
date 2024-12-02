package com.example.final_application_2024.data.remote

import com.example.final_application_2024.data.Faction
import com.example.final_application_2024.data.local.factions.FactionDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FactionsRemoteDatabase @Inject constructor(
    private val dao: FactionDao
):FactionsRemoteDataSource {
    override suspend fun create(faction: Faction) {
        TODO("Not yet implemented")
    }

    override suspend fun update(id: String, faction: Faction) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun readAll(): List<Faction> {
        TODO("Not yet implemented")
    }

    override suspend fun readOne(id: String): Faction {
        TODO("Not yet implemented")
    }

    override fun observeAll(): Flow<List<Faction>> {
        TODO("Not yet implemented")
    }
}