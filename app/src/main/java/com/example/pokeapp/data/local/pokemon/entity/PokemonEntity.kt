package com.example.pokeapp.data.local.pokemon.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemons")
data class PokemonEntity (

    @PrimaryKey
    val id: Int,

    val name: String,

    val primaryType: String,

    val secondaryType: String?
)