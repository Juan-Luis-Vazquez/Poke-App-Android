package com.example.pokeapp.data.datasource.pokemon

import com.example.pokeapp.data.network.pokemon.PokemonRequests
import com.example.pokeapp.data.network.pokemon.PokemonListResponseDto

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
}