package ru.slavicsky.chuckjokesapp.api.networking

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.slavicsky.chuckjokesapp.api.services.ChuckNorrisApi
import ru.slavicsky.chuckjokesapp.model.Joke
import ru.slavicsky.chuckjokesapp.model.JokesResponse

class RestProvider {
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.icndb.com")
            .addConverterFactory(MoshiConverterFactory.create())
            //Без нее тут легче будет
//            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
    }

    private val service = getRetrofit().create(ChuckNorrisApi::class.java)

    fun requestJokes(count: Int, onResult: (List<Joke>) -> Unit) {
        service.getJokes(count).enqueue(object : Callback<JokesResponse> {
            override fun onFailure(call: Call<JokesResponse>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<JokesResponse>, response: Response<JokesResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    onResult(response.body()!!.jokes)
                }
            }
        })
    }

}