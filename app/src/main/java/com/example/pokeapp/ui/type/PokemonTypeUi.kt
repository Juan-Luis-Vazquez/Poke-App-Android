package com.example.pokeapp.ui.type

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class PokemonTypeUi(
    val name: String,
    @ColorRes val gradientStart: Int,
    @ColorRes val gradientEnd: Int,
    @DrawableRes val iconRes: Int
)