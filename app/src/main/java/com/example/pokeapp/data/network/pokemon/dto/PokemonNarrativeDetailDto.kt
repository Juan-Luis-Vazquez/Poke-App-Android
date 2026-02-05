package com.example.pokeapp.data.network.pokemon.dto

import com.google.gson.annotations.SerializedName

data class PokemonNarrativeDetailDto (

    val id: Int,

    val name: String,

    val genera: List<GeneraDto>,

    @SerializedName("evolution_chain")
    val evolutionChain: EvolutionChainRefDto,

    @SerializedName("flavor_text_entries")
    val flavorTextEntries: List<TextEntryDto>

)

data class GeneraDto(

    val genus: String,

    val language: LanguageDto
)

data class TextEntryDto(

    val version: VersionDto,

    val language: LanguageDto,

    @SerializedName("flavor_text")
    val flavorText: String
)

data class LanguageDto(

    val name: String

)

data class VersionDto(

    val name: String

)

data class EvolutionChainRefDto(

    val url: String

)
