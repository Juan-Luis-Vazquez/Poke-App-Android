package com.example.pokeapp.domain.model.pokemon

import com.example.pokeapp.domain.model.type.TypeDetail

data class PokemonDetail (
    val id: Int,
    val name: String,
    val image: String,
    val height: Int,
    val weight: Int,
    val genus: String,
    val stats: PokemonDetailStats,
    val types: List<TypeDetail>,
    val abilities: List<PokemonDetailAbility>,
    val textEntries: List<PokemonDetailTextEntries>,
    val evolutions: List<PokemonDetailEvolution>

)

data class PokemonDetailAbility(
    val name: String,
    val infoUrl: String
)

data class PokemonDetailStats(
    val healPoints: Int,
    val attack: Int,
    val defense: Int,
    val specialAttack: Int,
    val specialDefense: Int,
    val velocity: Int
)

data class PokemonDetailTextEntries(
    val version: String,
    val textEntry: String
)

data class PokemonDetailEvolution(
    val id: Int,
    val name: String,
    val types: List<String>
)




