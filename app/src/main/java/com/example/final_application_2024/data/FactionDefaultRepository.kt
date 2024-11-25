package com.example.final_application_2024.data

import com.example.final_application_2024.data.local.FactionsLocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FactionDefaultRepository @Inject constructor(
    private val localDataSource: FactionsLocalDataSource,
    private val remoteDataSource: FactionsLocalDataSource
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
        return remoteDataSource.readOne(id)
    }

    override fun observeAll(): Flow<List<Faction>> {
        return remoteDataSource.observeAll()
    }
}