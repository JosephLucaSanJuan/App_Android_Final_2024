package com.example.final_application_2024.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TransformersApi {
    @GET("api/v2/transformers")
    suspend fun readAll():Response<TransformersListResponse>

    @GET("api/v2/transformers/{id}")
    suspend fun readOne(@Path("id") id:String):TransformersListResponse
}