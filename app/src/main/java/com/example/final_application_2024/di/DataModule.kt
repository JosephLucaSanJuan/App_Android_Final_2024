package com.example.final_application_2024.di

import com.example.final_application_2024.data.DefaultTransformersRepository
import com.example.final_application_2024.data.FactionDefaultRepository
import com.example.final_application_2024.data.FactionRepository
import com.example.final_application_2024.data.TransformersRepository
import com.example.final_application_2024.data.local.TransformersLocalDataSource
import com.example.final_application_2024.data.local.TransformersLocalDatabase
import com.example.final_application_2024.data.remote.TransformersNetworkDatabase
import com.example.final_application_2024.data.remote.TransformersRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindsTransformersRepository(repository: DefaultTransformersRepository):TransformersRepository

    @Binds
    @Singleton
    abstract fun bindsFactionRepository(repository: FactionDefaultRepository):FactionRepository

    @Binds
    @Singleton
    abstract fun bindsTransformersLocal(repository: TransformersLocalDatabase):TransformersLocalDataSource

    @Binds
    @Singleton
    abstract fun bindsTransformersRemote(repository: TransformersNetworkDatabase):TransformersRemoteDataSource
}