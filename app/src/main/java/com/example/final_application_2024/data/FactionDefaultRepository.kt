package com.example.final_application_2024.data

import com.example.final_application_2024.data.local.factions.FactionsLocalDataSource
import com.example.final_application_2024.data.remote.FactionsRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FactionDefaultRepository @Inject constructor(
    private val localDataSource: FactionsLocalDataSource,
    private val remoteDataSource: FactionsRemoteDataSource
):FactionRepository {
    override suspend fun create(name: String): Result<Faction> {
        val result = remoteDataSource.create(name)
        if (result.isSuccess) {
            val faction = result.getOrNull()
            faction?.let {
                localDataSource.create(it)
            }
        }
        return result
    }

    override suspend fun update(faction: Faction): Result<Faction> {
        val result = remoteDataSource.update(faction.id.toString(), faction)
        if (result.isSuccess) {
            //val faction = result.getOrNull()
            faction.let {
                localDataSource.update(faction)
            }
        }
        return result
    }

    override suspend fun delete(faction: Faction) {
        localDataSource.delete(faction)
    }

    override suspend fun readAll(): List<Faction> {
        return remoteDataSource.readAll()
    }

    override suspend fun readOne(id: Int): Result<Faction> {
        return localDataSource.readOne(id)
    }

    override fun observeAll(): Flow<Result<List<Faction>>> {
        return localDataSource.observeAll()
    }
}