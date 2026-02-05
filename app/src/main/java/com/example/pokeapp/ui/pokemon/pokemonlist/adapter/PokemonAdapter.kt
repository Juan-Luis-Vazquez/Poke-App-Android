package com.example.pokeapp.ui.pokemon.pokemonlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.pokeapp.databinding.ItemPokemonBinding
import com.example.pokeapp.domain.model.pokemon.Pokemon

class PokemonAdapter(
    private val onClick: (Pokemon) -> Unit
) :
    ListAdapter<Pokemon, PokemonViewHolder>(PokemonDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PokemonViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(
        holder: PokemonViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
}