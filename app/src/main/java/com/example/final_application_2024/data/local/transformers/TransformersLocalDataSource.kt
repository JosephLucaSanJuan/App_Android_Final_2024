package com.example.final_application_2024.data.local.transformers

import com.example.final_application_2024.data.Transformer
import kotlinx.coroutines.flow.Flow

interface TransformersLocalDataSource {
    suspend fun create(transformers:Transformer)
    suspend fun update(id:String, transformer:Transformer)
    suspend fun delete(id:String)
    suspend fun readAll(): List<Transformer>
    suspend fun readOne(id:String):Transformer
    fun observeAll(): Flow<List<Transformer>>
}