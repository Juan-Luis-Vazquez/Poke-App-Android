package com.example.pokeapp.ui.components

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.example.pokeapp.databinding.ViewTypeChipBinding
import com.example.pokeapp.ui.type.PokemonTypeUi

class TypeChipView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val binding =
        ViewTypeChipBinding.inflate(LayoutInflater.from(context), this, true)

    fun bind(config: PokemonTypeUi) {
        binding.text.text = config.name.uppercase()
        binding.icon.setImageResource(config.iconRes)

        val startColor = ContextCompat.getColor(context, config.gradientStart)
        val endColor = ContextCompat.getColor(context, config.gradientEnd)

        val gradient = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(startColor, endColor)
        )

        gradient.cornerRadius = 100f
        binding.root.background = gradient
    }
}