package com.example.final_application_2024.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FactionDefaultRepository @Inject constructor():FactionRepository {
    override suspend fun create(faction: Faction) {
        TODO("Not yet implemented")
    }

    override suspend fun update(faction: Faction) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(faction: Faction) {
        TODO("Not yet implemented")
    }

    override suspend fun readAll(): List<Faction> {
        TODO("Not yet implemented")
    }

    override suspend fun readOne(id: Int): Faction {
        TODO("Not yet implemented")
    }

    override fun observeAll(): Flow<List<Faction>> {
        TODO("Not yet implemented")
    }
}