package com.example.final_application_2024.di

import android.content.Context
import androidx.room.Room
import com.example.final_application_2024.data.local.factions.FactionDao
import com.example.final_application_2024.data.local.transformers.TransformersDao
import com.example.final_application_2024.data.TransformersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {
    @Provides
    @Singleton
    fun provideTransformersDatabase(@ApplicationContext context: Context): TransformersDatabase {
        val database = Room.databaseBuilder(
            context,
            TransformersDatabase::class.java,
            "transformers"
        )
        return database.build()
    }

    @Provides
    @Singleton
    fun provideTransformersDao(transformersDatabase: TransformersDatabase): TransformersDao = transformersDatabase.transformersDao()

    @Provides
    @Singleton
    fun provideFactionsDao(transformersDatabase: TransformersDatabase): FactionDao = transformersDatabase.factionDao()
}