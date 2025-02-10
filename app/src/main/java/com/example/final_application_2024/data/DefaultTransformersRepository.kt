package com.example.final_application_2024.data

import com.example.final_application_2024.data.local.transformers.TransformersLocalDataSource
import com.example.final_application_2024.data.remote.TransformersRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultTransformersRepository @Inject constructor(
    private val localDataSource: TransformersLocalDataSource,
    private val remoteDataSource: TransformersRemoteDataSource
):TransformersRepository {
    override suspend fun create(transformer: Transformer) {
        localDataSource.create(transformer)
    }

    override suspend fun update(transformer: Transformer) {
        localDataSource.update(transformer)
    }

    override suspend fun delete(transformer: Transformer) {
        localDataSource.delete(transformer)
    }

    override suspend fun readAll(): List<Transformer> {
        return remoteDataSource.readAll()
    }

    override suspend fun readOne(id: Int): Transformer {
        return remoteDataSource.readOne(id)
    }

    override fun observeAll(): Flow<Result<List<Transformer>>> {
        return localDataSource.observeAll()
    }
}