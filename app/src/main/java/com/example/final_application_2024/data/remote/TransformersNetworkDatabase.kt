package com.example.final_application_2024.data.remote

import com.example.final_application_2024.data.Transformer
import com.example.final_application_2024.data.toExternal
import com.example.final_application_2024.data.toLocal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransformersNetworkDatabase @Inject constructor(
    private val api: TransformersApi
):TransformersRemoteDataSource {
    override suspend fun create(transformer: Transformer) {
        api.create(transformer)
    }

    override suspend fun update(id: String, transformer: Transformer) {
        api.update(id, transformer)
    }

    override suspend fun delete(id: String) {
        api.delete(id)
    }

    override suspend fun readAll(): List<Transformer> {
        val result = api.readAll()
        return if (result.isSuccessful) {
            result.body()!!.toExternal()
        } else {
            listOf<Transformer>()
        }
    }

    override suspend fun readOne(id: String): Transformer {
        return this.api.readOne(id).toLocal()
    }

    override fun observeAll(): Flow<List<Transformer>> {
        TODO("Not yet implemented")
    }
}