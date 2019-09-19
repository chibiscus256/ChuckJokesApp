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

    val service: ChuckNorrisApi = RetrofitClient().getRetrofit().create(ChuckNorrisApi::class.java)
    val jokesList = service.getJokes(12)

/*    fun getData(): LiveData<String> {
        if (data == null) {
            data = MutableLiveData<Any>().toInt()
            loadData()
        }
        return data
    }

    fun loadList(jokesNumber: Int, adapter: JokesAdapter) {
        viewModelScope.launch {
            adapter.jokesList.getNetworkResponse(jokesNumber)
            println(jokesList)
        }
    }*/
}