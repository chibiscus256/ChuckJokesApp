package ru.slavicsky.chuckjokesapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.slavicsky.chuckjokesapp.R
import ru.slavicsky.chuckjokesapp.api.services.ApiFactory
import ru.slavicsky.chuckjokesapp.model.Joke
import ru.slavicsky.chuckjokesapp.model.JokesResponse
import ru.slavicsky.chuckjokesapp.view.viewholder.ViewHolder

class JokesAdapter() :
    RecyclerView.Adapter<ViewHolder>() {

    var jokesList: MutableList<Joke> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.joke_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return jokesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val joke = jokesList[position]
        holder.bindView(joke)
    }

/*    fun getNetworkResponse(number: Int) {
        val jokesService = ApiFactory.chuckNorrisApi
        val call = jokesService.getJokes(number)
        var jokesResponse: JokesResponse?

        call.enqueue(object : Callback<JokesResponse> {
            override fun onFailure(call: Call<JokesResponse>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<JokesResponse>,
                jokesList: Response<JokesResponse>
            ) {
                jokesResponse = jokesList.body()!!

            }
        })
    }*/

    fun loadlist(list: MutableList<Joke>) {
        jokesList = list
    }
}
