package com.example.final_application_2024.data.local.factions

import com.example.final_application_2024.data.Faction
import com.example.final_application_2024.exceptions.FactionNotFound
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FactionLocalDatabase @Inject constructor(
    private val dao: FactionDao
): FactionsLocalDataSource {
    override suspend fun create(faction: Faction): Result<Faction> {
        dao.create(faction.toLocal())
        return Result.success(faction)
    }

    override suspend fun update(faction: Faction) {
        dao.update(faction.toLocal())
    }

    override suspend fun delete(faction: Faction) {
        dao.delete(faction.toLocal())
    }

    override suspend fun readAll(): List<Faction> {
        return dao.readAll().toExternal()
    }

    override suspend fun readOne(id: Int): Result<Faction> {
        val faction:FactionEntity? = dao.readOne(id)
        faction?.let {
            return@readOne Result.success(it.toExternal())
        }
        return Result.failure(FactionNotFound())
    }

    override fun observeAll(): Flow<Result<List<Faction>>> {
        return dao.observeAll().map { localFactions ->
            val factions = localFactions.toExternal()
            Result.success(factions)
        }
    }
}