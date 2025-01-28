package com.example.final_application_2024.data

import com.example.final_application_2024.data.local.factions.FactionsLocalDataSource
import com.example.final_application_2024.data.remote.FactionsRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FactionDefaultRepository @Inject constructor(
    private val localDataSource: FactionsLocalDataSource,
    private val remoteDataSource: FactionsRemoteDataSource
):FactionRepository {
    override suspend fun create(faction: Faction) {
        localDataSource.create(faction)
    }

    override suspend fun update(faction: Faction) {
        localDataSource.update(faction)
    }

    override suspend fun delete(faction: Faction) {
        localDataSource.delete(faction)
    }

    override suspend fun readAll(): List<Faction> {
        return remoteDataSource.readAll()
    }

    override suspend fun readOne(id: Int): Faction {
        return localDataSource.readOne(id)
    }

    override fun observeAll(): Flow<List<Faction>> {
        return localDataSource.observeAll()
    }
}