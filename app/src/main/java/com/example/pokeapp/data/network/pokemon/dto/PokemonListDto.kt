package com.example.pokeapp.data.network.pokemon.dto

data class PokemonListResponseDto(
    val results: List<PokemonItemDto>
)

data class PokemonItemDto(
    val name: String,
    val url: String
)