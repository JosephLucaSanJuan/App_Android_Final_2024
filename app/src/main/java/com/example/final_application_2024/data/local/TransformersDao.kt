package com.example.final_application_2024.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TransformersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(transformer:TransformersEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(transformer:List<TransformersEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(vararg transformer:TransformersEntity)

    @Update
    suspend fun update(transformer: TransformersEntity)

    @Delete
    suspend fun delete(transformer: TransformersEntity)

    @Query("SELECT * FROM transformers")
    suspend fun readAll():List<TransformersEntity>

    @Query("SELECT * FROM transformers WHERE id LIKE :id")
    suspend fun readOne(id:Int):TransformersEntity

    @Query("SELECT * FROM transformers")
    fun observeAll():Flow<List<TransformersEntity>>
}