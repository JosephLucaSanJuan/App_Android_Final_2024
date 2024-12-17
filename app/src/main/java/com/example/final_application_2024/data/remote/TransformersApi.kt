package com.example.final_application_2024.data.remote

import com.example.final_application_2024.data.Faction
import com.example.final_application_2024.data.Transformer
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TransformersApi {
    @POST("api/transformers")
    suspend fun createTransformer(@Body transformer:Transformer)//:TransformersListResponse

    @PUT("api/transformers")
    suspend fun updateTransformer(@Body transformer:Transformer):TransformersListResponse

    @DELETE("api/transformers")
    suspend fun deleteTransformer(@Body transformer:Transformer)//:Response<TransformersListResponse>

    @GET("api/transformers")
    suspend fun readAllTransformers():Response<TransformersListResponse>

    @GET("api/transformers/{id}")
    suspend fun readOneTransformer(@Path("id") id:Int):TransformersListItemResponse

    @POST("api/factions")
    suspend fun createFaction(@Body faction:Faction)

    @PUT("api/factions/{id}")
    suspend fun updateFaction(@Path("id") id:String, @Body faction:Faction):FactionListResponse

    @DELETE("api/factions/{id}")
    suspend fun deleteFaction(@Path("id") id:String)

    @GET("api/factions")
    suspend fun readAllFactions():Response<FactionListResponse>

    @GET("api/factions/{id}")
    suspend fun readOneFaction(@Path("id") id:String):FactionListItemResponse

    @POST("api/auth/local")
    suspend fun login(@Body login:LoginResponseBody):Response<AuthResponseBody>

    @POST("api/auth/local/register")
    suspend fun register(@Body register:RegisterResponseBody):Response<AuthResponseBody>

    suspend fun logout()
}