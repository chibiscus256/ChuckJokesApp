package ru.slavicsky.chuckjokesapp.model.repo

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.slavicsky.chuckjokesapp.api.services.ApiFactory
import ru.slavicsky.chuckjokesapp.model.Joke
import ru.slavicsky.chuckjokesapp.model.JokesResponse
import ru.slavicsky.chuckjokesapp.model.dao.JokeDao
import javax.inject.Inject

class JokeRepository @Inject constructor(private val jokesList: JokeDao) {

    suspend fun getNetworkResponse(number: Int) {
        val jokesService = ApiFactory.chuckNorrisApi
        val call = jokesService.getJokes(number)
        var jokesResponse: JokesResponse?

        call.enqueue(object : Callback<JokesResponse> {
            override fun onFailure(call: Call<JokesResponse>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<JokesResponse>,
                jokesList: Response<JokesResponse>
            ) {
                jokesResponse = jokesList.body()!!

            }
        })
    }
}