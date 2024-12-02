package com.example.final_application_2024.data

import kotlinx.coroutines.flow.Flow

interface TransformersRepository {
    suspend fun create(transformer:Transformer)
    suspend fun update(id:String, transformer:Transformer)
    suspend fun delete(id:String)
    suspend fun readAll():List<Transformer>
    suspend fun readOne(id:String):Transformer
    fun observeAll():Flow<List<Transformer>>
}