package com.example.pokeapp.data.datasource.pokemon

import com.example.pokeapp.data.local.pokemon.dao.PokemonDao
import com.example.pokeapp.data.mapper.toEntity
import com.example.pokeapp.data.mapper.toListItem
import com.example.pokeapp.data.network.pokemon.dto.PokemonTechnicalDetailDto
import com.example.pokeapp.domain.model.pokemon.Pokemon

class PokemonLocalDataSource (
    private val dao: PokemonDao
){
    suspend fun hasData(): Boolean {
        return dao.getAll().isNotEmpty()
    }

    suspend fun exists(name: String): Boolean {

        val exists = dao.getByName(name)

        return( exists != null)
    }

    suspend fun getPokemonList(): List<Pokemon> {
        return dao.getAll().map { it.toListItem() }
    }

    suspend fun getById(id: Int): Pokemon? {
        return dao.getById(id)?.toListItem()
    }

    suspend fun getByName(name: String): Pokemon? {
        return dao.getByName(name)?.toListItem()
    }

    suspend fun saveAll(pokemons: List<PokemonTechnicalDetailDto>) {
        dao.insertAll(pokemons.map { it.toEntity() })
    }

    suspend fun save(pokemon: PokemonTechnicalDetailDto) {
        dao.insert(pokemon.toEntity())
    }

    suspend fun clear() {
        dao.clear()
    }
}