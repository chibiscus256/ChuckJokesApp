package ru.slavicsky.chuckjokesapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.slavicsky.chuckjokesapp.api.networking.RetrofitClient
import ru.slavicsky.chuckjokesapp.api.services.ChuckNorrisApi
import ru.slavicsky.chuckjokesapp.view.adapters.JokesAdapter

class JokesViewModel : ViewModel() {

    private val jokesLiveData = MutableLiveData<List<Joke>>()

    fun getJokesLiveData() = jokesLiveData

    fun requestJokes(count: Int){
        RepositoryProvider.requestJokes(count){
            jokesLiveData.postValue(it)
        }
    }
}
}