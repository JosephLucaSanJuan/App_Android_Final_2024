package com.example.final_application_2024.data.remote

import kotlinx.coroutines.flow.Flow
import javax.xml.transform.Transformer

interface TransformersRemoteDataSource {
    suspend fun readAll():List<Transformer>
    suspend fun readOne(id:Int):Transformer
    fun observeAll():Flow<List<Transformer>>
}