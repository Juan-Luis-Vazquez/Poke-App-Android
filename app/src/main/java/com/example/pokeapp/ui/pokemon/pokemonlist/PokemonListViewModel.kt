package com.example.pokeapp.ui.pokemon.pokemonlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokeapp.data.repository.pokemon.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonListViewModel(
    private val pokemonRepository: PokemonRepository
): ViewModel() {

    private val _state = MutableStateFlow<PokemonListEstate>(PokemonListEstate.Idle)
    val state: StateFlow<PokemonListEstate> = _state

    fun fetchPokemonList(){

        _state.value = PokemonListEstate.Loading

        viewModelScope.launch {
            _state.value = pokemonRepository
                .getPokemonPage(page = 1)
                .fold(
                    onSuccess = { list ->
                        PokemonListEstate.Success(list)
                    },
                    onFailure = {
                        PokemonListEstate.Error(it.message ?: "Unknown error")
                    }
                )
        }
    }
}