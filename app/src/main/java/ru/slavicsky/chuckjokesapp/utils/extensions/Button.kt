package ru.slavicsky.chuckjokesapp.utils.extensions

import android.text.Editable
import android.view.View
import android.widget.Button
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.slavicsky.chuckjokesapp.api.services.ApiFactory
import ru.slavicsky.chuckjokesapp.models.GetJokesResponse
import ru.slavicsky.chuckjokesapp.view.adapters.JokeListAdapter

fun Button.reload(input: Editable, adapter: JokeListAdapter) {
    val number = Integer.parseInt(input.toString())
    val jokesService = ApiFactory.chuckNorrisApi
    val call = jokesService.getJokes(number = number)
    var getJokesResponse: GetJokesResponse?

    call.enqueue(object : Callback<GetJokesResponse> {
        override fun onFailure(call: Call<GetJokesResponse>, t: Throwable) {
            t.printStackTrace()
        }

        override fun onResponse(
            call: Call<GetJokesResponse>,
            response: Response<GetJokesResponse>
        ) {
            getJokesResponse = response.body()
            adapter.jokes = getJokesResponse!!.jokeResponse
        }
    })
}