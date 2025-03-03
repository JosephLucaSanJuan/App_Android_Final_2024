package com.example.final_application_2024.data.local.factions

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FactionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(faction: FactionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(factions: List<FactionEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(vararg faction: FactionEntity)

    @Update
    suspend fun update(faction: FactionEntity)

    @Delete
    suspend fun delete(faction: FactionEntity)

    @Query("SELECT * FROM factions")
    suspend fun readAll():List<FactionEntity>

    @Query("SELECT * FROM factions WHERE id LIKE :id")
    suspend fun readOne(id: Int): FactionEntity?

    @Query("SELECT * FROM factions")
    fun observeAll(): Flow<List<FactionEntity>>
}