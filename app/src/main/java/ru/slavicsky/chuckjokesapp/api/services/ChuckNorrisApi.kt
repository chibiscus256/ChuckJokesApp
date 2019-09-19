package ru.slavicsky.chuckjokesapp.api.services

import androidx.lifecycle.LiveData
import retrofit2.http.GET
import retrofit2.http.Path
import ru.slavicsky.chuckjokesapp.api.networking.ApiResponse
import ru.slavicsky.chuckjokesapp.model.Joke
import ru.slavicsky.chuckjokesapp.model.JokesResponse

interface ChuckNorrisApi {
    @GET("jokes/random/{number}")
    fun getJokes(@Path("number") number: Int): Call<JokesResponse>
}

