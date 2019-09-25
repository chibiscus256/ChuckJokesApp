package ru.slavicsky.chuckjokesapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.slavicsky.chuckjokesapp.R
import ru.slavicsky.chuckjokesapp.model.Joke
import ru.slavicsky.chuckjokesapp.view.viewholder.ViewHolder

class JokesAdapter :
    RecyclerView.Adapter<ViewHolder>() {

    private var jokesList: MutableList<Joke> = arrayListOf()

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


    fun loadlist(list: List<Joke>) {
        jokesList.clear()
        jokesList.addAll(list)
        notifyDataSetChanged()
    }
}
