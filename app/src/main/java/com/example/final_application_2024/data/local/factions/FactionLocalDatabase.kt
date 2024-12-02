package com.example.final_application_2024.data.local.factions

import com.example.final_application_2024.data.Faction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FactionLocalDatabase @Inject constructor(
    private val dao: FactionDao
): FactionsLocalDataSource {
    override suspend fun create(faction: Faction) {
        dao.create(faction.toLocal())
    }

    override suspend fun update(id: String, faction: Faction) {
        dao.update(id, faction.toLocal())
    }

    override suspend fun delete(id: String) {
        dao.delete(id)
    }

    override suspend fun readAll(): List<Faction> {
        return dao.readAll().toExternal()
    }

    override suspend fun readOne(id: String): Faction {
        return dao.readOne(id).toExternal()
    }

    override fun observeAll(): Flow<List<Faction>> {
        return dao.observeAll().map { localFactions ->
            localFactions.toExternal()
        }
    }
}