package ru.slavicsky.chuckjokesapp.api.networking

import ru.slavicsky.chuckjokesapp.model.Joke


object RepositoryProvider{

    private val retrofitClient = RestProvider()

    fun requestJokes(count: Int, onResult: (List<Joke>) -> Unit)
            = retrofitClient.requestJokes(count, onResult)
}