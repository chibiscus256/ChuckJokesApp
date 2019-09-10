package ru.slavicsky.chuckjokesapp.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.slavicsky.chuckjokesapp.R
import ru.slavicsky.chuckjokesapp.models.GetJokesResponse
import ru.slavicsky.chuckjokesapp.models.JokeResponse
import ru.slavicsky.chuckjokesapp.view.viewholder.ViewHolder

class JokeListAdapter(private val jContext: Context) :
    RecyclerView.Adapter<ViewHolder>() {

    lateinit var jokes: List<JokeResponse>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.joke_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return if (::jokes.isInitialized) jokes.size else 0

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val joke = jokes[position]
        holder.jokeText!!.text = joke.value
    }

}
