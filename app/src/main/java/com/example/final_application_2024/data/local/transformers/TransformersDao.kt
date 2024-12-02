package com.example.final_application_2024.data.local.transformers

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
    suspend fun create(transformer: TransformersEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(transformer:List<TransformersEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(vararg transformer: TransformersEntity)

    @Update
    suspend fun update(id: String, transformer: TransformersEntity)

    @Delete
    suspend fun delete(id: String)

    @Query("SELECT * FROM transformers")
    suspend fun readAll():List<TransformersEntity>

    @Query("SELECT * FROM transformers WHERE id LIKE :id")
    suspend fun readOne(id:String): TransformersEntity

    @Query("SELECT * FROM transformers")
    fun observeAll():Flow<List<TransformersEntity>>
}