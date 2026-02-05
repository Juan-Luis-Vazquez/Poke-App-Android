package com.example.pokeapp.core

import android.content.Context
import com.example.pokeapp.data.datasource.pokemon.PokemonRemoteDataSource
import com.example.pokeapp.data.datasource.type.TypeLocalDataSource
import com.example.pokeapp.data.datasource.type.TypeRemoteDataSource
import com.example.pokeapp.data.local.DatabaseProvider
import com.example.pokeapp.data.network.ServerCommunicationManager
import com.example.pokeapp.data.network.pokemon.PokemonRequests
import com.example.pokeapp.data.network.type.TypeRequests
import com.example.pokeapp.data.repository.pokemon.PokemonRepository
import com.example.pokeapp.data.repository.type.TypeRepository

object ServiceLocator {

    @Volatile
    private var serverManager: ServerCommunicationManager? = null

    @Volatile
    private var pokemonRepository: PokemonRepository? = null
    @Volatile
    private var typeRepository: TypeRepository? = null

    private fun provideServerManager(): ServerCommunicationManager {
        return serverManager ?: synchronized(this) {
            serverManager ?: run {
                ServerCommunicationManager().also {
                    serverManager = it
                }
            }
        }
    }

    fun providePokemonRepository(context: Context): PokemonRepository{
        return pokemonRepository ?: synchronized(this){
            pokemonRepository?: run {

                val pokemonRequests = PokemonRequests(provideServerManager())

                val remoteDataSource = PokemonRemoteDataSource(pokemonRequests)

                PokemonRepository(
                    remoteDataSource =  remoteDataSource,
                    typeRepository = provideTypeRepository(context)
                ).also {
                    pokemonRepository = it
                }
            }
        }
    }

    fun provideTypeRepository(context: Context): TypeRepository {
        return typeRepository ?: synchronized(this) {

            val database = DatabaseProvider.get(context)
            val typeDao = database.typeDao()

            val localDataSource = TypeLocalDataSource(typeDao)

            val typeRequests = TypeRequests(provideServerManager())
            val remoteDataSource = TypeRemoteDataSource(typeRequests)

            TypeRepository(
                remoteDataSource = remoteDataSource,
                localDataSource = localDataSource
            ).also {
                typeRepository = it
            }
        }
    }

}