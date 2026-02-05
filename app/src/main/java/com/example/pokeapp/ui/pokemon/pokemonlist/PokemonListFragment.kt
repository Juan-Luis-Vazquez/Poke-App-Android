package com.example.pokeapp.ui.pokemon.pokemonlist

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokeapp.R
import com.example.pokeapp.databinding.FragmentPokemonListBinding
import com.example.pokeapp.ui.pokemon.pokemonlist.adapter.PokemonAdapter
import kotlinx.coroutines.launch

class PokemonListFragment : Fragment(R.layout.fragment_pokemon_list) {

    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PokemonListViewModel by viewModels {
        PokemonListViewModelFactory(requireContext())
    }

    private lateinit var adapter: PokemonAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentPokemonListBinding.bind(view)

        adapter = PokemonAdapter { pokemon ->
            val action =
                PokemonListFragmentDirections
                    .actionListToDetail(pokemon.id)

            findNavController().navigate(action)
        }

        binding.recycler.layoutManager =
            LinearLayoutManager(requireContext())
        binding.recycler.adapter = adapter

        observeState()

        viewModel.fetchPokemonList()
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    when (state) {
                        is PokemonListEstate.Success -> {
                            binding.recycler.visibility = View.VISIBLE
                            adapter.submitList(state.pokemonList)
                        }
                        PokemonListEstate.Loading -> {
                            Log.d("POKEMON", "Loading")
                            //binding.progress.visibility = View.VISIBLE
                        }
                        is PokemonListEstate.Error -> {
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