package com.example.pokeapp.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException
import java.util.concurrent.TimeUnit


class ServerCommunicationManager {

    private val BASE_URL = "https://pokeapi.co/api/v2/"

    private val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()

    suspend fun execute(url: String): ServerResponse<String> =
        withContext(Dispatchers.IO) {
            try {
                val request = buildHttpRequest(resolveUrl(path = url))
                val response = client.newCall(request).execute()

                ServerResponse(
                    statusCode = response.code,
                    body = response.body?.string(),
                    error = null
                )

            } catch (e: IOException) {

                ServerResponse(
                    statusCode = null,
                    body = null,
                    error = NetworkError.NoInternet
                )

            } catch (e: Exception) {
                ServerResponse(
                    statusCode = null,
                    body = null,
                    error = NetworkError.Unknown(e.message)
                )
            }
        }

    private fun buildHttpRequest(url: String): Request {
        return Request.Builder()
            .url(url)
            .get()
            .build()
    }

    private fun resolveUrl(path: String): String {
        return if (path.startsWith("http")) {
            path
        } else {
            BASE_URL + path
        }
    }
}