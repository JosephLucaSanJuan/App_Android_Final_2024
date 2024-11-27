package com.example.final_application_2024.data.remote

import kotlinx.coroutines.flow.Flow
import com.example.final_application_2024.data.Transformer

interface TransformersRemoteDataSource {
    suspend fun create(transformer:Transformer)
    suspend fun update(transformer:Transformer)
    suspend fun delete(transformer: Transformer)
    suspend fun readAll():List<Transformer>
    suspend fun readOne(id:Int):Transformer
    fun observeAll():Flow<List<Transformer>>
}