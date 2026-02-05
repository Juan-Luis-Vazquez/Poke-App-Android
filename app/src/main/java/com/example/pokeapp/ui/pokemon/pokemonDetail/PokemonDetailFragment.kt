package com.example.pokeapp.ui.pokemon.pokemonDetail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import com.example.pokeapp.R
import com.example.pokeapp.databinding.FragmentPokemonDetailBinding
import kotlinx.coroutines.launch

class PokemonDetailFragment: Fragment(R.layout.fragment_pokemon_detail) {

    private val args: PokemonDetailFragmentArgs by navArgs()

    private var _binding: FragmentPokemonDetailBinding? = null
    val binding get() = _binding!!

    private val viewModel: PokemonDetailViewModel by viewModels {
        PokemonDetailViewModelFactory(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentPokemonDetailBinding.bind(view)

        observeState()

        val pokemonId = args.pokemonId
        viewModel.fetchPokemonDetail(pokemonId)
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    when (state) {
                        is PokemonDetailState.Success -> {
                           Log.d("POKEMON", state.pokemon.toString())
                        }
                        PokemonDetailState.Loading -> {
                            Log.d("POKEMON", "Loading")
                            //binding.progress.visibility = View.VISIBLE
                        }
                        is PokemonDetailState.Error -> {
                            Log.d("POKEMON", "ERROR ${state.message}")
                            //binding.errorText.text = state.message
                        }
                        else -> Unit
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}