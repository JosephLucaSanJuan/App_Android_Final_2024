package com.example.final_application_2024.di

import android.content.Context
import androidx.room.Room
import com.example.final_application_2024.data.local.TransformersDao
import com.example.final_application_2024.data.local.TransformersDatabase
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
    fun provideDatabase(@ApplicationContext context: Context): TransformersDatabase {
        val database = Room.databaseBuilder(
            context,
            TransformersDatabase::class.java,
            "transformers-db"
        )
        return database.build()
    }

    @Provides
    fun provideDao(transformersDatabase:TransformersDatabase): TransformersDao = transformersDatabase.transformersDao()
}