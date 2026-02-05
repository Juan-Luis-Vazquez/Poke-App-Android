package com.example.pokeapp.domain.model.type

data class TypeDetail(
    val id: Int,
    val name: String,
    val iconUrl: String,
    val weaknesses: List<String>,
    val strengths: List<String>,
    val resistances: List<String>,
    val immunities: List<String>
)