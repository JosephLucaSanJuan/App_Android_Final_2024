package com.example.final_application_2024.data

import kotlinx.coroutines.flow.Flow

interface TransformersRepository {
    suspend fun create(name:String, altMode:String, gender:String): Result<Transformer>
    suspend fun update(id:Int, transformer:Transformer): Result<Transformer>
    suspend fun delete(transformer:Transformer)
    suspend fun readAll():List<Transformer>
    suspend fun readOne(id:Int):Result<Transformer>
    fun observeAll():Flow<Result<List<Transformer>>>
}