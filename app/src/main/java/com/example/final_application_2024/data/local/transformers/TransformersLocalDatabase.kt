package com.example.final_application_2024.data.local.transformers

import com.example.final_application_2024.data.Transformer
import com.example.final_application_2024.exceptions.TransformerNotFoundException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TransformersLocalDatabase @Inject constructor(
    private val dao: TransformersDao
): TransformersLocalDataSource {
    override suspend fun create(transformers: Transformer): Result<Transformer> {
        dao.create(transformers.toLocal())
        return Result.success(transformers)
    }

    override suspend fun update(id: Int, transformer: Transformer): Result<Transformer> {
        dao.update(transformer.toLocal())
        return Result.success(transformer)
    }

    override suspend fun delete(transformer: Transformer) {
        dao.delete(transformer.toLocal())
    }

    override suspend fun readAll(): List<Transformer> {
        return dao.readAll().toExternal()
    }

    override suspend fun readOne(id: Int): Result<Transformer> {
        val entity:TransformersEntity? = dao.readOne(id)
        entity?.let {
            return@readOne Result.success(it.toExternal())
        }
        return Result.failure(TransformerNotFoundException())
    }

    override fun observeAll(): Flow<Result<List<Transformer>>> {
        return dao.observeAll().map { localTransformers ->
            val transformers = localTransformers.toExternal()
            Result.success(transformers)
        }
    }
}