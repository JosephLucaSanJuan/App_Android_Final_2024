package com.example.final_application_2024.data.remote

import com.example.final_application_2024.data.Transformer
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransformersNetworkDatabase @Inject constructor():TransformersRemoteDataSource {
    override suspend fun create(transformers: Transformer) {
        TODO("Not yet implemented")
    }

    override suspend fun update(transformer: Transformer) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(transformer: Transformer) {
        TODO("Not yet implemented")
    }

    override suspend fun readAll(): List<Transformer> {
        TODO("Not yet implemented")
    }

    override suspend fun readOne(id: Int): Transformer {
        TODO("Not yet implemented")
    }

    override fun observeAll(): Flow<List<Transformer>> {
        TODO("Not yet implemented")
    }
}