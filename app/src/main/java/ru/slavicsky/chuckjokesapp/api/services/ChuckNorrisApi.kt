package ru.slavicsky.chuckjokesapp.api.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import ru.slavicsky.chuckjokesapp.models.GetJokesResponse

interface ChuckNorrisApi {

    @GET("jokes/random/{number}")
    fun getJokes(@Path("number") number: Int): Call<GetJokesResponse>
}
