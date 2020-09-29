package ru.slavicsky.chuckjokesapp.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.slavicsky.chuckjokesapp.data.Resource
import ru.slavicsky.chuckjokesapp.data.repository.DataRepository
import ru.slavicsky.chuckjokesapp.model.Joke

class JokesViewModel @ViewModelInject constructor(private val repository: DataRepository) :
    ViewModel() {

    private val _fetchedJokes = MutableLiveData<Resource<List<Joke>>>()
    val fetchedJokes: LiveData<Resource<List<Joke>>> = _fetchedJokes

    fun requestJokes(count: Int) {
        viewModelScope.launch {
            _fetchedJokes.value = Resource.Loading()
            _fetchedJokes.postValue(repository.fetchJokes(count))
        }
    }
}

