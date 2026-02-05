package com.example.pokeapp.data.network.pokemon

import com.example.pokeapp.data.network.ServerCommunicationManager
import com.example.pokeapp.data.network.pokemon.dto.PokemonEvolutionChainDto
import com.example.pokeapp.data.network.pokemon.dto.PokemonListResponseDto
import com.example.pokeapp.data.network.pokemon.dto.PokemonNarrativeDetailDto
import com.example.pokeapp.data.network.pokemon.dto.PokemonTechnicalDetailDto
import com.google.gson.Gson

class PokemonRequests(
    private val network: ServerCommunicationManager
) {

    suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): PokemonListResponseDto {

        val response = network.execute(
            PokemonApi.list(limit, offset)
        )

        if (!response.isSuccessful || response.body == null) {
            throw IllegalStateException("Network error: ${response.error}")
        }

        return Gson().fromJson(response.body, PokemonListResponseDto::class.java)
    }

    suspend fun getPokemonNarrativeDetail(id: Int): PokemonNarrativeDetailDto {

        val response = network.execute(
            PokemonApi.narrativeDetail(id)
        )

        if (!response.isSuccessful || response.body == null) {
            throw IllegalStateException("Network error: ${response.error}")
        }

        return Gson().fromJson(response.body, PokemonNarrativeDetailDto::class.java)
    }

    suspend fun getPokemonTechnicalDetail(id: Int): PokemonTechnicalDetailDto {

        val response = network.execute(
            PokemonApi.technicalDetail(id)
        )

        if (!response.isSuccessful || response.body == null) {
            throw IllegalStateException("Network error: ${response.error}")
        }

        return Gson().fromJson(response.body, PokemonTechnicalDetailDto::class.java)
    }

    suspend fun getEvolutionChain(
        evolutionChainUrl: String
    ): PokemonEvolutionChainDto {

        val response = network.execute(
            url = evolutionChainUrl
        )

        if (!response.isSuccessful || response.body == null) {
            throw IllegalStateException("Network error: ${response.error}")
        }

        return Gson().fromJson(response.body, PokemonEvolutionChainDto::class.java)
    }
}