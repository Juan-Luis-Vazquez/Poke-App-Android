package com.example.pokeapp.data.datasource.pokemon

import com.example.pokeapp.data.network.pokemon.dto.PokemonEvolutionChainDto
import com.example.pokeapp.data.network.pokemon.PokemonRequests
import com.example.pokeapp.data.network.pokemon.dto.PokemonListResponseDto
import com.example.pokeapp.data.network.pokemon.dto.PokemonNarrativeDetailDto
import com.example.pokeapp.data.network.pokemon.dto.PokemonTechnicalDetailDto

class PokemonRemoteDataSource(
    private val requests: PokemonRequests
) {

    suspend fun fetchPokemonList(
        limit: Int,
        offset: Int
    ): PokemonListResponseDto {
        return requests.getPokemonList(
            limit = limit,
            offset = offset
        )
    }

    suspend fun fetchTechnicalDetailsById(id: Int): PokemonTechnicalDetailDto {
        return requests.getPokemonTechnicalDetailById(id = id)
    }

    suspend fun fetchTechnicalDetailsByName(name: String): PokemonTechnicalDetailDto {
        return requests.getPokemonTechnicalDetailByName(name = name)
    }

    suspend fun fetchNarrativeDetails(id: Int): PokemonNarrativeDetailDto {
        return requests.getPokemonNarrativeDetail(id)
    }

    suspend fun fetchEvolutionChain(url: String): PokemonEvolutionChainDto {
        return requests.getEvolutionChain(url)
    }
}