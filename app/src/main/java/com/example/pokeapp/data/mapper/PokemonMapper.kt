package com.example.pokeapp.data.mapper

import com.example.pokeapp.data.local.pokemon.dao.PokemonDao
import com.example.pokeapp.data.local.pokemon.entity.PokemonEntity
import com.example.pokeapp.data.network.pokemon.dto.EvolutionChainNodeDto
import com.example.pokeapp.data.network.pokemon.dto.NamedResourceDto
import com.example.pokeapp.data.network.pokemon.dto.PokemonAbilitySlotDto
import com.example.pokeapp.data.network.pokemon.dto.PokemonItemDto
import com.example.pokeapp.data.network.pokemon.dto.PokemonStatSlotDto
import com.example.pokeapp.data.network.pokemon.dto.PokemonTechnicalDetailDto
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

fun EvolutionChainNodeDto.toDomain(): List<PokemonDetailEvolution> {
    val current = PokemonDetailEvolution(
        id = species.idFromUrl(),
        name = species.name,
        types = emptyList()
    )

    return listOf(current) + evolvesTo.flatMap { it.toDomain() }
}

fun PokemonEntity.toListItem(): Pokemon {

    return Pokemon(
        id = id,
        name = name,
        types = buildTypes(
            primary = primaryType,
            secondary = secondaryType
        ),
        imageUrl = PokemonImageProvider.officialArtwork(id)

    )
}

fun PokemonTechnicalDetailDto.toEntity(): PokemonEntity {
    return PokemonEntity(
        id = id,
        name = name,
        primaryType = types.first().type.name,
        secondaryType = types.getOrNull(1)?.type?.name
    )
}

fun PokemonTechnicalDetailDto.toListItem(): Pokemon {

    return Pokemon(
        id = id,
        name = name,
        types = buildTypes(
            primary = types.first().type.name,
            secondary = types.getOrNull(1)?.type?.name
        ),
        imageUrl =  PokemonImageProvider.officialArtwork(id)
    )
}

fun NamedResourceDto.idFromUrl(): Int =
    url.trimEnd('/').substringAfterLast('/').toInt()

private fun buildTypes(
    primary: String,
    secondary: String?
): List<String> {
    return buildList {
        add(primary)
        secondary?.let { add(it) }
    }
}
