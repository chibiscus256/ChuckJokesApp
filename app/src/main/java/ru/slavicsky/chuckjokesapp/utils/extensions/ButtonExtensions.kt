package ru.slavicsky.chuckjokesapp.utils.extensions

import android.text.Editable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.slavicsky.chuckjokesapp.api.services.ApiFactory
import ru.slavicsky.chuckjokesapp.models.GetJokesResponse
import ru.slavicsky.chuckjokesapp.view.adapters.JokeListAdapter

fun reload(input: Editable, adapter: JokeListAdapter) {
    var number = Integer.parseInt(input.toString())
    val jokesService = ApiFactory.chuckNorrisApi
    val call = jokesService.getJokes(number = number)
    var jokesResponse: GetJokesResponse?

    call.enqueue(object : Callback<GetJokesResponse> {
        override fun onFailure(call: Call<GetJokesResponse>, t: Throwable) {
            t.printStackTrace()
        }

        override fun onResponse(
            call: Call<GetJokesResponse>,
            response: Response<GetJokesResponse>
        ) {
            jokesResponse = response.body()
            adapter.jokes = jokesResponse!!.jokeResponse
        }
    })
}