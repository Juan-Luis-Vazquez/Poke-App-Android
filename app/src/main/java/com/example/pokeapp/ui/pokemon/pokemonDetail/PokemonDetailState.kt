package com.example.pokeapp.ui.pokemon.pokemonDetail

import com.example.pokeapp.domain.model.pokemon.PokemonDetail

sealed class PokemonDetailState {
    object Idle : PokemonDetailState()
    object Loading: PokemonDetailState()
    data class Success(
        val pokemon: PokemonDetail
    ) : PokemonDetailState()

    data class Error(
        val message: String
    ) : PokemonDetailState()
}