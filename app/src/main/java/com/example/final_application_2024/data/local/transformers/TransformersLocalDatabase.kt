package com.example.final_application_2024.data.local.transformers

import com.example.final_application_2024.data.Transformer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TransformersLocalDatabase @Inject constructor(
    private val dao: TransformersDao
): TransformersLocalDataSource {
    override suspend fun create(transformers: Transformer) {
        dao.create(transformers.toLocal())
    }

    override suspend fun update(transformer: Transformer) {
        dao.update(transformer.toLocal())
    }

    override suspend fun delete(transformer: Transformer) {
        dao.delete(transformer.toLocal())
    }

    override suspend fun readAll(): List<Transformer> {
        return dao.readAll().toExternal()
    }

    override suspend fun readOne(id: Int): Transformer {
        return (dao.readOne(id)).toExternal()
    }

    override fun observeAll(): Flow<Result<List<Transformer>>> {
        return dao.observeAll().map { localTransformers ->
            val transformers = localTransformers.toExternal()
            Result.success(transformers)
        }
    }
}