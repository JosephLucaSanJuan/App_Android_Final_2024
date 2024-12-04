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
        api.createTransformer(transformer)
    }

    override suspend fun update(transformer: Transformer) {
        api.updateTransformer(transformer)
    }

    override suspend fun delete(transformer: Transformer) {
        api.deleteTransformer(transformer)
    }

    override suspend fun readAll(): List<Transformer> {
        val result = api.readAllTransformers()
        return if (result.isSuccessful) {
            result.body()!!.toExternal()
        } else {
            listOf<Transformer>()
        }
    }

    override suspend fun readOne(id: Int): Transformer {
        return this.api.readOneTransformer(id).toLocal()
    }

    override fun observeAll(): Flow<List<Transformer>> {
        TODO("Not yet implemented")
    }
}