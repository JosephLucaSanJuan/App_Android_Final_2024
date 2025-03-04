package com.example.final_application_2024.data

import com.example.final_application_2024.data.local.transformers.TransformersLocalDataSource
import com.example.final_application_2024.data.remote.TransformersRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultTransformersRepository @Inject constructor(
    private val localDataSource: TransformersLocalDataSource,
    private val remoteDataSource: TransformersRemoteDataSource
):TransformersRepository {
    override suspend fun create(name:String, altMode:String, gender:String): Result<Transformer> {
        val result = remoteDataSource.create(name, altMode, gender)
        if (result.isSuccess) {
            val transformer = result.getOrNull()
            transformer?.let {
                localDataSource.create(it)
            }
        }
        return result
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

    override suspend fun readOne(id: Int): Result<Transformer> {
        return localDataSource.readOne(id)
    }

    override fun observeAll(): Flow<Result<List<Transformer>>> {
        return localDataSource.observeAll()
    }
}