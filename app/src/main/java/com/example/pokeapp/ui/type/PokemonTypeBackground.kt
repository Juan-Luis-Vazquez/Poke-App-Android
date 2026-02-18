package com.example.pokeapp.ui.type

import com.example.pokeapp.R
import com.example.pokeapp.domain.model.type.PokemonType

object PokemonTypeBackground {

    fun getBackgroundColorRes(type: PokemonType): Int {
        return when (type) {
            PokemonType.GRASS -> R.color.type_grass_bg
            PokemonType.POISON -> R.color.type_poison_bg
            PokemonType.FIRE -> R.color.type_fire_bg
            PokemonType.WATER -> R.color.type_water_bg
            PokemonType.ELECTRIC -> R.color.type_electric_bg
            PokemonType.ICE -> R.color.type_ice_bg
            PokemonType.FIGHTING -> R.color.type_fighting_bg
            PokemonType.FAIRY -> R.color.type_fairy_bg
            PokemonType.STEEL -> R.color.type_steel_bg
            PokemonType.GROUND -> R.color.type_ground_bg
            PokemonType.ROCK -> R.color.type_rock_bg
            PokemonType.BUG -> R.color.type_bug_bg
            PokemonType.GHOST -> R.color.type_ghost_bg
            PokemonType.DARK -> R.color.type_dark_bg
            PokemonType.DRAGON -> R.color.type_dragon_bg
            PokemonType.NORMAL -> R.color.type_normal_bg
            PokemonType.PSYCHIC -> R.color.type_psychic_bg
            PokemonType.FLYING -> R.color.type_flying_bg
        }
    }
}