package com.example.pokeapp.data.util

object PokemonImageProvider {

    fun officialArtwork(id: Int): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
    }
}