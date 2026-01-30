package com.example.pokeapp.core

import android.content.Context
import com.example.pokeapp.data.datasource.pokemon.PokemonRemoteDataSource
import com.example.pokeapp.data.network.ServerCommunicationManager
import com.example.pokeapp.data.network.pokemon.PokemonRequests
import com.example.pokeapp.data.repository.pokemon.PokemonRepository

object ServiceLocator {

    @Volatile
    private var serverManager: ServerCommunicationManager? = null

    @Volatile
    private var pokemonRepository: PokemonRepository? = null

    private fun provideServerManager(): ServerCommunicationManager {
        return serverManager ?: synchronized(this) {
            serverManager ?: run {
                ServerCommunicationManager().also {
                    serverManager = it
                }
            }
        }
    }

    fun providePokemonRepository(): PokemonRepository{
        return pokemonRepository ?: synchronized(this){
            pokemonRepository?: run {

                val pokemonRequests = PokemonRequests(provideServerManager())

                val remoteDataSource = PokemonRemoteDataSource(pokemonRequests)

                PokemonRepository(remoteDataSource).also {
                    pokemonRepository = it
                }
            }
        }
    }

}