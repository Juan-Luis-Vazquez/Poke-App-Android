package com.example.pokeapp.data.repository.pokemon

import com.example.pokeapp.data.datasource.pokemon.PokemonLocalDataSource
import com.example.pokeapp.data.datasource.pokemon.PokemonRemoteDataSource
import com.example.pokeapp.data.mapper.toDomain
import com.example.pokeapp.data.mapper.toEntity
import com.example.pokeapp.data.mapper.toListItem
import com.example.pokeapp.data.repository.type.TypeRepository
import com.example.pokeapp.data.util.PokemonImageProvider
import com.example.pokeapp.domain.model.pokemon.Pokemon
import com.example.pokeapp.domain.model.pokemon.PokemonDetail
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class PokemonRepository(
    private val remoteDataSource: PokemonRemoteDataSource,
    private val localDataSource: PokemonLocalDataSource,
    private val typeRepository: TypeRepository
) {
    suspend fun getPokemonPage(
        page: Int,
        pageSize: Int = 500
    ): Result<List<Pokemon>> {
        return try {
            coroutineScope {

                val offset = page * pageSize

                val response = remoteDataSource.fetchPokemonList(
                    limit = pageSize,
                    offset = offset
                )

                val deferred = response.results.map { item ->
                    async {

                        localDataSource.getByName(item.name)
                            ?: run {
                                val technical =
                                    remoteDataSource.fetchTechnicalDetailsByName(item.name)

                                localDataSource.save(
                                    technical
                                )

                                technical.toListItem()
                            }
                    }
                }

                Result.success(deferred.awaitAll())
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getPokemonDetail(id: Int): Result<PokemonDetail>{

        return try {
            coroutineScope {

                val technicalDeferred = async {
                    remoteDataSource.fetchTechnicalDetailsById(id)
                }

                val narrativeDeferred = async {
                    remoteDataSource.fetchNarrativeDetails(id)
                }

                val technical = technicalDeferred.await()
                val narrative = narrativeDeferred.await()

                val evolutionDeferred = async {
                    remoteDataSource.fetchEvolutionChain(
                        narrative.evolutionChain.url
                    )
                }

                val evolution = evolutionDeferred.await()

                val types = technical.types.mapNotNull {
                    typeRepository
                        .getTypeDetailByName(it.type.name)
                        .getOrNull()
                }

                Result.success(
                    PokemonDetail(
                        id = technical.id,
                        name = technical.name,
                        image = PokemonImageProvider.officialArtwork(technical.id),
                        height = technical.height,
                        weight = technical.weight,
                        genus = narrative.genera
                            .first { it.language.name == "en" }
                            .genus,
                        stats = technical.stats.toDomain(),
                        types = types,
                        abilities = technical.abilities.toDomain(),
                        textEntries = narrative.flavorTextEntries.toDomain(),
                        evolutions = evolution.chain.toDomain()
                    )
                )
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}