package com.example.pokeapp.data.mapper

import com.example.pokeapp.data.network.pokemon.dto.EvolutionChainNodeDto
import com.example.pokeapp.data.network.pokemon.dto.NamedResourceDto
import com.example.pokeapp.data.network.pokemon.dto.PokemonAbilitySlotDto
import com.example.pokeapp.data.network.pokemon.dto.PokemonEvolutionChainDto
import com.example.pokeapp.data.network.pokemon.dto.PokemonItemDto
import com.example.pokeapp.data.network.pokemon.dto.PokemonStatSlotDto
import com.example.pokeapp.data.network.pokemon.dto.TextEntryDto
import com.example.pokeapp.data.util.PokemonImageProvider
import com.example.pokeapp.domain.model.pokemon.Pokemon
import com.example.pokeapp.domain.model.pokemon.PokemonDetailAbility
import com.example.pokeapp.domain.model.pokemon.PokemonDetailEvolution
import com.example.pokeapp.domain.model.pokemon.PokemonDetailStats
import com.example.pokeapp.domain.model.pokemon.PokemonDetailTextEntries

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

fun List<PokemonStatSlotDto>.toDomain(): PokemonDetailStats {

    fun stat(name: String): Int =
        firstOrNull { it.stat.name == name }?.baseStat ?: 0

    return PokemonDetailStats(
        healPoints = stat("hp"),
        attack = stat("attack"),
        defense = stat("defense"),
        specialAttack = stat("special-attack"),
        specialDefense = stat("special-defense"),
        velocity = stat("speed")
    )
}

fun List<PokemonAbilitySlotDto>.toDomain(): List<PokemonDetailAbility> {
    return map {
        PokemonDetailAbility(
            name = it.ability.name,
            infoUrl = "https://pokeapi.co/api/v2/ability/${it.ability.name}"
        )
    }
}

fun List<TextEntryDto>.toDomain(
    language: String = "en"
): List<PokemonDetailTextEntries> {
    return filter { it.language.name == language }
        .map {
            PokemonDetailTextEntries(
                version = it.version.name,
                textEntry = it.flavorText.replace("\n", " ")
            )
        }
}

fun EvolutionChainNodeDto.toDomain(
    result: MutableList<PokemonDetailEvolution> = mutableListOf()
): List<PokemonDetailEvolution> {

    result.add(
        PokemonDetailEvolution(
            id = species.idFromUrl(),
            name = species.name,
            types = emptyList()
        )
    )

    evolvesTo.forEach { next ->
        next.toDomain(result)
    }

    return result
}

fun NamedResourceDto.idFromUrl(): Int =
    url.trimEnd('/').substringAfterLast('/').toInt()

