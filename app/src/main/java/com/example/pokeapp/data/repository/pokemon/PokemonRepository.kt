package com.example.pokeapp.data.repository.pokemon

import com.example.pokeapp.data.datasource.pokemon.PokemonRemoteDataSource
import com.example.pokeapp.data.mapper.toDomain
import com.example.pokeapp.domain.model.pokemon.Pokemon

class PokemonRepository(
    private val remoteDataSource: PokemonRemoteDataSource
) {
    suspend fun getPokemonPage(
        page: Int,
        pageSize: Int = 20
    ): Result<List<Pokemon>> {
        return try {
            val offset = page * pageSize
            val response = remoteDataSource.fetchPokemonList(
                limit = pageSize,
                offset = offset
            )

            Result.success(
                response.results.map { it.toDomain() }
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}