package ru.slavicsky.chuckjokesapp.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import ru.slavicsky.chuckjokesapp.R
import ru.slavicsky.chuckjokesapp.model.Joke

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
        holder.bindData(joke)
    }

    fun loadlist(list: List<Joke>) {
        jokesList.clear()
        jokesList.addAll(list)
        notifyDataSetChanged()
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val jokeView: TextView? = itemView.findViewById(R.id.joke_text)

    fun bindData(entity: Joke) {
        val newString: String = HtmlCompat.fromHtml(entity.value, 0).toString()
        jokeView?.text = newString
    }
}
