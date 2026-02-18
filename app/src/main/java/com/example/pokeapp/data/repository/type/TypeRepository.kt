package com.example.pokeapp.data.repository.type

import com.example.pokeapp.data.datasource.type.TypeLocalDataSource
import com.example.pokeapp.data.datasource.type.TypeRemoteDataSource
import com.example.pokeapp.data.mapper.toDomain
import com.example.pokeapp.domain.model.type.PokemonType
import com.example.pokeapp.domain.model.type.TypeDetail

class TypeRepository (
    private val remoteDataSource: TypeRemoteDataSource,
    private val localDataSource: TypeLocalDataSource
) {

    suspend fun getTypes(): Result<List<PokemonType>> {
        return try {

            val response = remoteDataSource.fetchTypesList()

            Result.success(
                response.results.map { it.toDomain() }
            )
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    suspend fun getTypeDetailById(id: Int): Result<TypeDetail> {
        return try {

            val response = remoteDataSource.fetchTypeDetailsById(id)

            Result.success(
                response.toDomain()
            )

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getTypeDetailByName(name: String): Result<TypeDetail> {
        return try {

            val response = remoteDataSource.fetchTypeDetailsByName(name)

            Result.success(
                response.toDomain()
            )

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}