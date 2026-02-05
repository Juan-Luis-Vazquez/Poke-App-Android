package com.example.pokeapp.data.network.pokemon.dto

import com.google.gson.annotations.SerializedName

data class PokemonEvolutionChainDto(
    val id: Int,
    val chain: EvolutionChainNodeDto
)

data class EvolutionChainNodeDto(
    val species: NamedResourceDto,

    @SerializedName("evolves_to")
    val evolvesTo: List<EvolutionChainNodeDto>
)

data class NamedResourceDto(
    val name: String,
    val url: String
)