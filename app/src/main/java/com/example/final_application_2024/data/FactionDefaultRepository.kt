package com.example.final_application_2024.data

import com.example.final_application_2024.data.local.factions.FactionsLocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FactionDefaultRepository @Inject constructor(
    private val localDataSource: FactionsLocalDataSource,
    private val remoteDataSource: FactionsLocalDataSource
):FactionRepository {
    override suspend fun create(faction: Faction) {
        localDataSource.create(faction)
    }

    override suspend fun update(id: String, faction: Faction) {
        localDataSource.update(id, faction)
    }

    override suspend fun delete(id: String) {
        localDataSource.delete(id)
    }

    override suspend fun readAll(): List<Faction> {
        return remoteDataSource.readAll()
    }

    override suspend fun readOne(id: String): Faction {
        return remoteDataSource.readOne(id)
    }

    override fun observeAll(): Flow<List<Faction>> {
        return remoteDataSource.observeAll()
    }
}