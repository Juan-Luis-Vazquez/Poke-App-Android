package com.example.pokeapp.ui.pokemon.pokemonDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokeapp.data.repository.pokemon.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonDetailViewModel(
    private val pokemonRepository: PokemonRepository
): ViewModel() {

    private val _state = MutableStateFlow<PokemonDetailState>(PokemonDetailState.Idle)
    val state: StateFlow<PokemonDetailState> = _state

    fun fetchPokemonDetail(id: Int){

        viewModelScope.launch {
            _state.value = PokemonDetailState.Loading

            _state.value = pokemonRepository.getPokemonDetail(id)
                .fold(
                    onSuccess = { pokemonDetail ->
                        PokemonDetailState.Success(pokemonDetail)
                    },
                    onFailure = {
                        PokemonDetailState.Error(it.message ?: "Unknown error")
                    }
                )
        }
    }
}