package com.example.pokeapp.data.network.pokemon

data class PokemonListResponseDto(
    val results: List<PokemonItemDto>
)

data class PokemonItemDto(
    val name: String,
    val url: String
)