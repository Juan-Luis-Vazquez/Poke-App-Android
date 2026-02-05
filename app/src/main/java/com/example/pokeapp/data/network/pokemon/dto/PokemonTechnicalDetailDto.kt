package com.example.pokeapp.data.network.pokemon.dto

import com.google.gson.annotations.SerializedName

data class PokemonTechnicalDetailDto(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val order: Int,
    val abilities: List<PokemonAbilitySlotDto>,
    val types: List<PokemonTypeSlotDto>,
    val stats: List<PokemonStatSlotDto>,
    val sprites: PokemonSpritesDto
)
data class PokemonSpritesDto(
    @SerializedName("back_default")
    val backDefault: String?,

    @SerializedName("front_default")
    val frontDefault: String?,

    @SerializedName("other")
    val other: OtherSpritesDto
)

data class OtherSpritesDto(
    @SerializedName("official-artwork")
    val officialArtWork: OfficialSpritesDto
)

data class OfficialSpritesDto(
    @SerializedName("back_default")
    val backDefault: String?,

    @SerializedName("front_default")
    val frontDefault: String?
)

data class PokemonTypeSlotDto(
    val type: PokemonTypeDto
)

data class PokemonTypeDto(
    val name: String
)

data class PokemonStatSlotDto(
    @SerializedName("base_stat")
    val baseStat: Int,
    val stat: PokemonStatDto
)

data class PokemonStatDto(
    val name: String
)

data class PokemonAbilitySlotDto(
    val ability: PokemonAbilityDto
)

data class PokemonAbilityDto(
    val name: String,
    val url: String
)