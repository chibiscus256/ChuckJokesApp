package ru.slavicsky.chuckjokesapp.view.viewholder

import androidx.core.text.HtmlCompat.fromHtml
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.slavicsky.chuckjokesapp.R
import ru.slavicsky.chuckjokesapp.models.JokeResponse

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val jokeView: TextView? = itemView.findViewById(R.id.joke_text)

    fun bindView(entity: JokeResponse){
        val newString: String = fromHtml(entity.value, 0).toString()
        jokeView?.text = newString
    }
}