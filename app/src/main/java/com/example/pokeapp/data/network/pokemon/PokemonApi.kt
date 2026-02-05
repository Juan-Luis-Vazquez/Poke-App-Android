package com.example.pokeapp.data.network.pokemon

object PokemonApi {

    private const val BASE_POKEMON = "pokemon"
    private const val BASE_POKEMON_SPECIES = "pokemon-species"

    fun list(
        limit: Int,
        offset: Int
    ): String {
        return "$BASE_POKEMON?limit=$limit&offset=$offset"
    }

    fun technicalDetail(id: Int): String {
        return "$BASE_POKEMON/$id"
    }

    fun narrativeDetail(id: Int): String {
        return "$BASE_POKEMON_SPECIES/$id"
    }
}