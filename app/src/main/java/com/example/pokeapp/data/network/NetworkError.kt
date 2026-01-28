package com.example.pokeapp.data.network

sealed class NetworkError {
    object NoInternet : NetworkError()
    object ServerError : NetworkError()
    data class Unknown(val message: String?) : NetworkError()
}