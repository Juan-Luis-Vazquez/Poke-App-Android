package com.example.pokeapp.data.local.type.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokeapp.data.local.type.entity.TypeEntity

@Dao
interface TypeDao {

    @Query("SELECT * FROM types")
    suspend fun getAll(): List<TypeEntity>

    @Query("SELECT * FROM types WHERE id = :id")
    suspend fun getById(id: Int): TypeEntity?

    @Query("SELECT * FROM types WHERE name = :name")
    suspend fun getByName(name: String): TypeEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(types: List<TypeEntity>)

    @Query("DELETE FROM types")
    suspend fun clear()
}