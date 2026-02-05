package com.example.pokeapp.data.network.type.dto

data class TypeListDto (
    val results: List<TypeItemDto>
)

data class TypeItemDto(
    val name: String,
    val url: String
)