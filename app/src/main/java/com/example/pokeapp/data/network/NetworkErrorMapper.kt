package com.example.pokeapp.data.network

object NetworkErrorMapper {

    fun toException(response: ServerResponse<*>): Throwable {
        return when (val error = response.error) {

            NetworkError.NoInternet ->
                Exception("No internet connection")

            NetworkError.ServerError ->
                Exception("Server error")

            is NetworkError.Unknown ->
                Exception(error.message ?: "Unknown error")

            null ->
                Exception("Unknown error")
        }
    }
}