package ru.slavicsky.chuckjokesapp.data.repository

import retrofit2.Response
import ru.slavicsky.chuckjokesapp.data.Error.Companion.NETWORK_ERROR
import ru.slavicsky.chuckjokesapp.data.Resource
import ru.slavicsky.chuckjokesapp.data.api.services.JokesService
import ru.slavicsky.chuckjokesapp.model.Joke
import ru.slavicsky.chuckjokesapp.model.JokesResponse
import java.io.IOException
import javax.inject.Inject

class DataRepository @Inject constructor(private val service: JokesService) {

    suspend fun fetchJokes(number: Int): Resource<List<Joke>> {
        return when (val response = processCall { (service::getJokes)(number) }) {
            is JokesResponse -> {
                Resource.Success(response.jokes)
            }
            else -> {
                Resource.DataError(response.toString())
            }
        }

    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }
}