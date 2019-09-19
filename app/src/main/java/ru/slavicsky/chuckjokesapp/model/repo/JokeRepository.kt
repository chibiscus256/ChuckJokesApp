package ru.slavicsky.chuckjokesapp.model.repo

import androidx.lifecycle.LiveData
import ru.slavicsky.chuckjokesapp.model.Joke

interface JokeRepository {
    suspend fun getList(number : Int): LiveData<MutableList<Joke>>
}