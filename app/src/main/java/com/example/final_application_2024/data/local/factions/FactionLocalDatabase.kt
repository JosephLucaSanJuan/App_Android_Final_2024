package com.example.final_application_2024.data.local.factions

import com.example.final_application_2024.data.Faction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FactionLocalDatabase @Inject constructor(
    private val dao: FactionDao
): FactionsLocalDataSource {
    override suspend fun create(name: String) {
        //dao.create(faction.toLocal())
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

    override suspend fun readOne(id: Int): Faction {
        return dao.readOne(id).toExternal()
    }

    override fun observeAll(): Flow<Result<List<Faction>>> {
        return dao.observeAll().map { localFactions ->
            val factions = localFactions.toExternal()
            Result.success(factions)
        }
    }
}