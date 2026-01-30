package com.example.pokeapp.data.mapper

import com.example.pokeapp.data.network.pokemon.PokemonItemDto
import com.example.pokeapp.data.util.PokemonImageProvider
import com.example.pokeapp.domain.model.pokemon.Pokemon

fun PokemonItemDto.toDomain(): Pokemon {
    val id = extractPokemonId(url)

    return Pokemon(
        id = id,
        name = name.replaceFirstChar { it.uppercase() },
        imageUrl = PokemonImageProvider.officialArtwork(id)
    )
}

private fun extractPokemonId(url: String): Int {
    return url.trimEnd('/')
        .split('/')
        .last()
        .toInt()
}