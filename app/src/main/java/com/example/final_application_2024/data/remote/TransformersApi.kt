package com.example.final_application_2024.data.remote

import com.example.final_application_2024.data.Transformer
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TransformersApi {
    @POST("api/v2/transformers")
    suspend fun create(@Body transformer: Transformer)//:Response<TransformersListResponse>

    @PUT("api/v2/transformers/{id}")
    suspend fun update(@Path("id") id:String):TransformersListResponse

    @DELETE("api/v2/transformers/{id}")
    suspend fun delete()//:Response<TransformersListResponse>

    @GET("api/v2/transformers")
    suspend fun readAll():Response<TransformersListResponse>

    @GET("api/v2/transformers/{id}")
    suspend fun readOne(@Path("id") id:String):TransformersListResponse
}