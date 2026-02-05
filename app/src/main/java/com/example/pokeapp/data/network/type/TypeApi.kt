package com.example.pokeapp.data.network.type


object TypeApi {

    private const val BASE_TYPE = "type"

    fun list(): String {
        return BASE_TYPE
    }

    fun byId(id: Int): String {
        return "$BASE_TYPE/$id"
    }

    fun byName(name: String): String {
        return "$BASE_TYPE/$name"
    }
}