package com.example.pokeapp.ui.pokemon.pokemonlist

import com.example.pokeapp.data.repository.pokemon.PokemonRepository
import com.example.pokeapp.domain.model.pokemon.Pokemon
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PokemonListViewModelTest {

    private lateinit var viewModel: PokemonListViewModel
    private val repository: PokemonRepository = mockk()

    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        viewModel = PokemonListViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when repository returns pokemon list then state is Success`() = runTest {

        // GIVEN
        val pokemonList = listOf(
            Pokemon(id = 1, name = "bulbasaur", ""),
            Pokemon(id = 2, name = "ivysaur", "")
        )

        coEvery {
            repository.getPokemonPage(page = 1)
        } returns Result.success(pokemonList)

        // WHEN
        viewModel.fetchPokemonList()
        advanceUntilIdle()

        // THEN
        val state = viewModel.state.value

        assertTrue(state is PokemonListEstate.Success)
        assertTrue(
            (state as PokemonListEstate.Success).pokemonList.size == 2
        )
    }
}