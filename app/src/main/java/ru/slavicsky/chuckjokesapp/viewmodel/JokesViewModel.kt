package ru.slavicsky.chuckjokesapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.slavicsky.chuckjokesapp.api.networking.RepositoryProvider
import ru.slavicsky.chuckjokesapp.model.Joke

class JokesViewModel : ViewModel() {

    private val jokesLiveData = MutableLiveData<List<Joke>>()

    fun getJokesLiveData() = jokesLiveData

    fun requestJokes(count: Int) {
        RepositoryProvider.requestJokes(count) {
            jokesLiveData.postValue(it)
        }
    }
}
