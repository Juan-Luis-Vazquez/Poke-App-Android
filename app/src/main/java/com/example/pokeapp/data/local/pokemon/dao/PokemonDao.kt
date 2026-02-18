package com.example.pokeapp.data.local.pokemon.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokeapp.data.local.pokemon.entity.PokemonEntity

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemons")
    suspend fun getAll(): List<PokemonEntity>

    @Query("SELECT * FROM pokemons WHERE id = :id")
    suspend fun getById(id: Int): PokemonEntity?

    @Query("SELECT * FROM pokemons WHERE name = :name")
    suspend fun getByName(name: String): PokemonEntity?

    @Query("SELECT * FROM pokemons WHERE id IN (:ids)")
    suspend fun getByIds(ids: List<Int>): List<PokemonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemons: List<PokemonEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: PokemonEntity)

    @Query("DELETE FROM pokemons")
    suspend fun clear()
}