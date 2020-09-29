package ru.slavicsky.chuckjokesapp.data.api.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import ru.slavicsky.chuckjokesapp.model.JokesResponse

interface ChuckNorrisApi {
    @GET("jokes/random/{number}")
    fun getJokes(@Path("number") number: Int): Call<JokesResponse>
}

