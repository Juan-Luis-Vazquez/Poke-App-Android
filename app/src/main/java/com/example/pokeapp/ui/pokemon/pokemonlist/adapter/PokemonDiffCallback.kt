package com.example.pokeapp.ui.pokemon.pokemonlist.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.pokeapp.domain.model.pokemon.Pokemon

class PokemonDiffCallback : DiffUtil.ItemCallback<Pokemon>() {

    override fun areItemsTheSame(
        oldItem: Pokemon,
        newItem: Pokemon
    ): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: Pokemon,
        newItem: Pokemon
    ): Boolean {
        return oldItem == newItem
    }
}