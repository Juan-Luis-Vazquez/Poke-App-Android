package com.example.pokeapp.ui.pokemon.pokemonDetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokeapp.core.ServiceLocator

class PokemonDetailViewModelFactory(
    private val context: Context
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonDetailViewModel::class.java)){
            val pokemonRepository = ServiceLocator.providePokemonRepository(context = context)
            @Suppress("UNCHECKED_CAST")
            return PokemonDetailViewModel(pokemonRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
