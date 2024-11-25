package com.example.final_application_2024.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TransformersApi {
    /*@POST("api/v2/transformers")
    suspend fun create():Response<TransformersListResponse>

    @GET("api/v2/transformers/{id}")
    suspend fun update(@Path("id") id:String):TransformersListResponse*/

    @GET("api/v2/transformers")
    suspend fun readAll():Response<TransformersListResponse>

    @GET("api/v2/transformers/{id}")
    suspend fun readOne(@Path("id") id:String):TransformersListResponse
}