package com.example.pokeapp.data.network.pokemon

object PokemonApi {

    private const val BASE = "pokemon"

    fun list(
        limit: Int,
        offset: Int
    ): String {
        return "$BASE?limit=$limit&offset=$offset"
    }

    fun detail(idOrName: String): String {
        return "$BASE/$idOrName"
    }
}