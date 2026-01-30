package com.example.pokeapp.ui.pokemon.pokemonlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokeapp.core.ServiceLocator

class PokemonListViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonListViewModel::class.java)){

            val pokemonRepository = ServiceLocator.providePokemonRepository()

            @Suppress("UNCHECKED_CAST")
            return PokemonListViewModel(pokemonRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}