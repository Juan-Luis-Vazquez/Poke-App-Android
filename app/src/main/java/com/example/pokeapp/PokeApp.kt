package com.example.pokeapp

import android.app.Application
import com.example.pokeapp.core.ServiceLocator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokeApp : Application() {

    override fun onCreate() {
        super.onCreate()

        CoroutineScope(Dispatchers.IO).launch {

            val typeRepository =
                ServiceLocator.provideTypeRepository(this@PokeApp)

            try {
                typeRepository.getTypes()
            } catch (e: Exception) {

            }
        }
    }
}