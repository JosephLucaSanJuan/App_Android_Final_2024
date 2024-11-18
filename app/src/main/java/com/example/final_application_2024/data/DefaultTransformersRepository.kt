package com.example.final_application_2024.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultTransformersRepository @Inject constructor():TransformersRepository {
    override suspend fun create() {
        TODO("Not yet implemented")
    }

    override suspend fun update(transformer: Transformer) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Int) {
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