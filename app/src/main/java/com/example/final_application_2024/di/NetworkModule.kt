package com.example.final_application_2024.di

import com.example.final_application_2024.data.remote.TransformersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val TRANSFORMER_API_URL = "https://transformers-service.onrender.com/"

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideTransformerApi(): TransformersApi{
        val service = Retrofit.Builder()
            .baseUrl(TRANSFORMER_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TransformersApi::class.java)
        return service
    }
}