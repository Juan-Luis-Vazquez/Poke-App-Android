package com.example.pokeapp.ui.pokemon.pokemonlist

import com.example.pokeapp.domain.model.pokemon.Pokemon

sealed class PokemonListEstate {
    object Idle : PokemonListEstate()
    object Loading: PokemonListEstate()
    data class Success(
        val pokemon: List<Pokemon>
    ) : PokemonListEstate()

    data class Error(
        val message: String
    ) : PokemonListEstate()
}