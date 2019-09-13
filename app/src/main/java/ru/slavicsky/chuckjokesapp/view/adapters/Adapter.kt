package ru.slavicsky.chuckjokesapp.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.slavicsky.chuckjokesapp.R
import ru.slavicsky.chuckjokesapp.models.JokeResponse
import ru.slavicsky.chuckjokesapp.view.viewholder.ViewHolder

class Adapter(private val jContext: Context) :
    RecyclerView.Adapter<ViewHolder>() {

    var jokes: MutableList<JokeResponse> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.joke_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val joke = jokes[position]
        holder.bindView(joke)
    }

    fun loadlist(list: MutableList<JokeResponse>) {
        jokes = list
    }
}
