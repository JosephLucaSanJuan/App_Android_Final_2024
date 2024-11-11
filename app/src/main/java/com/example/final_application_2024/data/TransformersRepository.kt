package com.example.final_application_2024.data

import kotlinx.coroutines.flow.Flow

interface TransformersRepository {
    suspend fun create()
    suspend fun update(transformer:Transformer)
    suspend fun delete(id:Int)
    suspend fun readAll():List<Transformer>
    suspend fun readOne(id:Int):Transformer
    fun observeAll():Flow<List<Transformer>>
}