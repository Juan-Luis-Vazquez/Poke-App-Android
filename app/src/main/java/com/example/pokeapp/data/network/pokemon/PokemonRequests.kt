package com.example.pokeapp.data.network.pokemon

import com.example.pokeapp.data.network.ServerCommunicationManager
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

        return parse(response.body)
    }

    private fun parse(json: String): PokemonListResponseDto {
        return Gson().fromJson(json, PokemonListResponseDto::class.java)
    }
}