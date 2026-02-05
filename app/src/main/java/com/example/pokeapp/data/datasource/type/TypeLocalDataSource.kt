package com.example.pokeapp.data.datasource.type

import com.example.pokeapp.data.local.type.dao.TypeDao
import com.example.pokeapp.data.mapper.toDomain
import com.example.pokeapp.data.mapper.toEntity
import com.example.pokeapp.domain.model.type.TypeDetail

class TypeLocalDataSource(
    private val dao: TypeDao
) {

    suspend fun hasData(): Boolean {
        return dao.getAll().isNotEmpty()
    }

    suspend fun getAll(): List<TypeDetail> {
        return dao.getAll().map { it.toDomain() }
    }

    suspend fun getById(id: Int): TypeDetail? {
        return dao.getById(id)?.toDomain()
    }

    suspend fun getByName(name: String): TypeDetail? {
        return dao.getByName(name)?.toDomain()
    }

    suspend fun saveAll(types: List<TypeDetail>) {
        dao.insertAll(types.map { it.toEntity() })
    }

    suspend fun clear() {
        dao.clear()
    }
}