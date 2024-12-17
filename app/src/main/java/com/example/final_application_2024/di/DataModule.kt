package com.example.final_application_2024.di

import com.example.final_application_2024.data.DefaultTransformersRepository
import com.example.final_application_2024.data.DefaultUserRepository
import com.example.final_application_2024.data.FactionDefaultRepository
import com.example.final_application_2024.data.FactionRepository
import com.example.final_application_2024.data.TransformersRepository
import com.example.final_application_2024.data.UserRepository
import com.example.final_application_2024.data.local.factions.FactionLocalDatabase
import com.example.final_application_2024.data.local.factions.FactionsLocalDataSource
import com.example.final_application_2024.data.local.transformers.TransformersLocalDataSource
import com.example.final_application_2024.data.local.transformers.TransformersLocalDatabase
import com.example.final_application_2024.data.local.users.UserLocalDatabase
import com.example.final_application_2024.data.local.users.UsersLocalDataSource
import com.example.final_application_2024.data.remote.FactionsRemoteDataSource
import com.example.final_application_2024.data.remote.FactionsRemoteDatabase
import com.example.final_application_2024.data.remote.TransformersNetworkDatabase
import com.example.final_application_2024.data.remote.TransformersRemoteDataSource
import com.example.final_application_2024.data.remote.UserRemoteDataSource
import com.example.final_application_2024.data.remote.UserRemoteDatabase
import dagger.Binds
import dagger.Module
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
    abstract fun bindsUserRepository(repository: DefaultUserRepository):UserRepository

    @Binds
    @Singleton
    abstract fun bindsTransformersLocal(repository: TransformersLocalDatabase): TransformersLocalDataSource

    @Binds
    @Singleton
    abstract fun bindsTransformersRemote(repository: TransformersNetworkDatabase):TransformersRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsFactionsLocal(repository: FactionLocalDatabase): FactionsLocalDataSource

    @Binds
    @Singleton
    abstract fun bindsFactionsRemote(repository: FactionsRemoteDatabase):FactionsRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsUsersLocal(repository: UserLocalDatabase): UsersLocalDataSource

    @Binds
    @Singleton
    abstract fun bindsUsersRemote(repository: UserRemoteDatabase):UserRemoteDataSource
}