package ru.slavicsky.chuckjokesapp.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.core.text.HtmlCompat.fromHtml
import androidx.recyclerview.widget.RecyclerView
import ru.slavicsky.chuckjokesapp.R
import ru.slavicsky.chuckjokesapp.model.Joke

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val jokeView: TextView? = itemView.findViewById(R.id.joke_text)

    fun bindView(entity: Joke) {
        val newString: String = fromHtml(entity.value, 0).toString()
        jokeView?.text = newString
    }
}