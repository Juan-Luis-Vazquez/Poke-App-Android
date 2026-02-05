package com.example.pokeapp.data.network.type

import com.example.pokeapp.data.network.ServerCommunicationManager
import com.example.pokeapp.data.network.pokemon.PokemonApi
import com.example.pokeapp.data.network.pokemon.dto.PokemonListResponseDto
import com.example.pokeapp.data.network.type.dto.TypeDto
import com.example.pokeapp.data.network.type.dto.TypeListDto
import com.google.gson.Gson

class TypeRequests(
    private val network: ServerCommunicationManager
) {

    suspend fun getAllTypes(): TypeListDto {

        val response = network.execute(
            TypeApi.list()
        )

        if (!response.isSuccessful || response.body == null) {
            throw IllegalStateException("Network error: ${response.error}")
        }

        return Gson().fromJson(response.body, TypeListDto::class.java)
    }


    suspend fun getTypeById(id: Int): TypeDto {

        val response = network.execute(
            TypeApi.byId(id)
        )

        if (!response.isSuccessful || response.body == null) {
            throw IllegalStateException("Network error: ${response.error}")
        }

        return Gson().fromJson(response.body, TypeDto::class.java)
    }

    suspend fun getTypeByName(name: String): TypeDto {

        val response = network.execute(
            TypeApi.byName(name)
        )

        if (!response.isSuccessful || response.body == null) {
            throw IllegalStateException("Network error: ${response.error}")
        }

        return Gson().fromJson(response.body, TypeDto::class.java)
    }
}