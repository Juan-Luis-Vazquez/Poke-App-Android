package com.example.pokeapp.data.datasource.type

import com.example.pokeapp.data.network.type.TypeRequests
import com.example.pokeapp.data.network.type.dto.TypeDto
import com.example.pokeapp.data.network.type.dto.TypeListDto

class TypeRemoteDataSource(
    private val requests: TypeRequests
) {

    suspend fun fetchTypesList(): TypeListDto {
        return requests.getAllTypes()
    }

    suspend fun fetchTypeDetailsById(id: Int): TypeDto{
        return requests.getTypeById(id)
    }

    suspend fun fetchTypeDetailsByName(name: String): TypeDto{
        return requests.getTypeByName(name)
    }
}