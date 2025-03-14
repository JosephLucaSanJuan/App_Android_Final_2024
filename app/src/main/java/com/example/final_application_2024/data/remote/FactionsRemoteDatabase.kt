package com.example.final_application_2024.data.remote

import com.example.final_application_2024.data.Faction
import com.example.final_application_2024.data.Transformer
import com.example.final_application_2024.data.local.factions.FactionDao
import com.example.final_application_2024.data.local.factions.FactionEntity
import com.example.final_application_2024.data.toExternal
import com.example.final_application_2024.data.toLocal
import com.example.final_application_2024.exceptions.FactionDataNotProperlyReceived
import com.example.final_application_2024.exceptions.FactionNotFound
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
data class FactionCreatePayloadWrapper(
    val data: FactionCreatePayload
)

data class FactionCreatePayload(
    val name: String
)
class FactionsRemoteDatabase @Inject constructor(
    private val api: TransformersApi
):FactionsRemoteDataSource {
    override suspend fun create(name: String):Result<Faction> {
        val response = api.createFaction(FactionCreatePayloadWrapper(FactionCreatePayload(name)))
        return if (response.isSuccessful) {
            Result.success(response.body()!!.toLocal())
        } else {
            Result.failure(FactionDataNotProperlyReceived())
        }
    }

    override suspend fun update(id: String, faction: Faction):Result<Faction> {
        val response = api.updateFaction(id, FactionUpdatePayloadWrapper(faction))
        return if (response.isSuccessful) {
            Result.success(response.body()!!.toLocal())
        } else {
            Result.failure(FactionDataNotProperlyReceived())
        }
    }

    override suspend fun delete(id: String) {
        api.deleteFaction(id)
    }

    override suspend fun readAll(): List<Faction> {
        val result = api.readAllFactions()
        return if (result.isSuccessful) {
            result.body()!!.toExternal()
        } else {
            listOf<Faction>()
        }
    }

    override suspend fun readOne(id: String): Result<Faction> {
        val result = api.readOneFaction(id)
        return if (result.isSuccessful) {
            Result.success(result.body()!!.toExternal())
        } else {
            Result.failure(FactionNotFound())
        }
    }

    override fun observeAll(): Flow<List<Faction>> {
        TODO("Not yet implemented")
    }
}