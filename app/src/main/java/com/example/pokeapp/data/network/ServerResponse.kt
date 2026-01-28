package com.example.pokeapp.data.network

data class ServerResponse<T>(
    val statusCode: Int?,
    val body: T?,
    val error: NetworkError?
) {
    val isSuccessful: Boolean
        get() = error == null && statusCode != null && statusCode in 200..299
}