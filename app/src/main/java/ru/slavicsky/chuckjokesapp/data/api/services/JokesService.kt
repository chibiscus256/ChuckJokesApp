package ru.slavicsky.chuckjokesapp.data.api.services

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.slavicsky.chuckjokesapp.model.JokesResponse

interface JokesService {
    companion object {
        val ENDPOINT: String = "https://api.icndb.com"
    }

    @GET("jokes/random/{number}")
    suspend fun getJokes(@Path("number") number: Int): Response<JokesResponse>
}

