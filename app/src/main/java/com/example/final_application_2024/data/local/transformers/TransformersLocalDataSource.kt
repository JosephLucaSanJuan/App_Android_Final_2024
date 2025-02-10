package com.example.final_application_2024.data.local.transformers

import com.example.final_application_2024.data.Transformer
import kotlinx.coroutines.flow.Flow

interface TransformersLocalDataSource {
    suspend fun create(transformers:Transformer)
    suspend fun update(transformer:Transformer)
    suspend fun delete(transformer:Transformer)
    suspend fun readAll(): List<Transformer>
    suspend fun readOne(id:Int):Transformer
    fun observeAll(): Flow<Result<List<Transformer>>>
}