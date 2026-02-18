package com.example.pokeapp.ui.type

import com.example.pokeapp.R
import com.example.pokeapp.domain.model.type.PokemonType

object PokemonTypeUiConfig {

    fun get(type: PokemonType): PokemonTypeUi {
        return when (type) {

            PokemonType.FIRE -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_fire,
                gradientEnd = R.color.type_secondary_fire,
                iconRes = R.drawable.ic_fire
            )

            PokemonType.GRASS -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_grass,
                gradientEnd = R.color.type_secondary_grass,
                iconRes = R.drawable.ic_grass
            )

            PokemonType.NORMAL -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_normal,
                gradientEnd = R.color.type_secondary_normal,
                iconRes = R.drawable.ic_fire
            )
            PokemonType.WATER -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_water,
                gradientEnd = R.color.type_secondary_water,
                iconRes = R.drawable.ic_water
            )
            PokemonType.ELECTRIC -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_electric,
                gradientEnd = R.color.type_secondary_electric,
                iconRes = R.drawable.ic_electric
            )
            PokemonType.ICE -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_ice,
                gradientEnd = R.color.type_secondary_ice,
                iconRes = R.drawable.ic_ice
            )
            PokemonType.FIGHTING -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_fighting,
                gradientEnd = R.color.type_secondary_fighting,
                iconRes = R.drawable.ic_fighting
            )
            PokemonType.POISON -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_poison,
                gradientEnd = R.color.type_secondary_poison,
                iconRes = R.drawable.ic_poison
            )
            PokemonType.GROUND -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_ground,
                gradientEnd = R.color.type_secondary_ground,
                iconRes = R.drawable.ic_ground
            )
            PokemonType.FLYING -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_flying,
                gradientEnd = R.color.type_secondary_flying,
                iconRes = R.drawable.ic_flying
            )
            PokemonType.PSYCHIC -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_psychic,
                gradientEnd = R.color.type_secondary_psychic,
                iconRes = R.drawable.ic_psychic
            )
            PokemonType.BUG -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_bug,
                gradientEnd = R.color.type_secondary_bug,
                iconRes = R.drawable.ic_bug
            )
            PokemonType.ROCK -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_rock,
                gradientEnd = R.color.type_secondary_rock,
                iconRes = R.drawable.ic_rock
            )
            PokemonType.GHOST -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_ghost,
                gradientEnd = R.color.type_secondary_ghost,
                iconRes = R.drawable.ic_ghost
            )
            PokemonType.DRAGON -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_dragon,
                gradientEnd = R.color.type_secondary_dragon,
                iconRes = R.drawable.ic_dragon
            )
            PokemonType.DARK -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_dark,
                gradientEnd = R.color.type_secondary_dark,
                iconRes = R.drawable.ic_dark
            )
            PokemonType.STEEL -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_steel,
                gradientEnd = R.color.type_secondary_steel,
                iconRes = R.drawable.ic_steel
            )
            PokemonType.FAIRY -> PokemonTypeUi(
                name = type.name,
                gradientStart = R.color.type_primary_fairy,
                gradientEnd = R.color.type_secondary_fairy,
                iconRes = R.drawable.ic_fairy
            )
        }
    }
}