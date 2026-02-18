package com.example.pokeapp.ui.pokemon.pokemonlist.adapter

import android.graphics.drawable.GradientDrawable
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.databinding.ItemPokemonBinding
import com.example.pokeapp.domain.model.pokemon.Pokemon
import com.example.pokeapp.domain.model.type.PokemonType
import com.example.pokeapp.ui.components.TypeChipView
import com.example.pokeapp.ui.type.PokemonTypeUiConfig
import coil.load
import com.example.pokeapp.ui.type.PokemonTypeBackground

class PokemonViewHolder(
    private val binding: ItemPokemonBinding,
    private val onClick: (Pokemon) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemon: Pokemon) {

        binding.pokemonName.text = pokemon.name.capitalize()
        binding.pokemonNumber.text =
            "N.º ${pokemon.id.toString().padStart(4, '0')}"

        binding.root.setOnClickListener {
            onClick(pokemon)
        }

        binding.typesContainer.removeAllViews()

        pokemon.types.forEach { type ->
            val chip = TypeChipView(binding.root.context)
            val config = PokemonTypeUiConfig.get(PokemonType.from(type))
            chip.bind(config)

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.marginEnd = 12
            chip.layoutParams = params

            binding.typesContainer.addView(chip)
        }

        binding.pokemonImage.load(pokemon.imageUrl) {
            crossfade(true)
        }

        val context = binding.root.context

        val primaryType = PokemonType.from(pokemon.types.first())
        val bgColorRes = PokemonTypeBackground.getBackgroundColorRes(primaryType)
        val bgBaseColor = ContextCompat.getColor(context, bgColorRes)
        val bgColorWithAlpha = bgBaseColor and 0x00FFFFFF or (0x8C shl 24)
        val strokeWidth = (1 * context.resources.displayMetrics.density).toInt()

        val backgroundDrawable = GradientDrawable().apply {
            cornerRadius = 150f
            setColor(bgColorWithAlpha)

            setStroke(
                strokeWidth,
                bgBaseColor
            )
        }

        binding.cardContainer.background = backgroundDrawable
    }
}