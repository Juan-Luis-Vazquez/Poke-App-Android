package com.example.pokeapp.ui.pokemon.pokemonlist.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.databinding.ItemPokemonBinding
import com.example.pokeapp.domain.model.pokemon.Pokemon

class PokemonViewHolder(
    private val binding: ItemPokemonBinding,
    private val onClick: (Pokemon) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemon: Pokemon) {
        binding.name.text = pokemon.name
        binding.root.setOnClickListener {
            onClick(pokemon)
        }
    }
}