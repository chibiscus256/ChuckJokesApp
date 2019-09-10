package ru.slavicsky.chuckjokesapp.view.ui

import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.slavicsky.chuckjokesapp.R
import ru.slavicsky.chuckjokesapp.models.JokeResponse
import ru.slavicsky.chuckjokesapp.utils.extensions.reload
import ru.slavicsky.chuckjokesapp.view.adapters.JokeListAdapter
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {

    lateinit var jokes: List<JokeResponse>
    private lateinit var jokeAdapter: JokeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultsButton = results_button
        val editText = search_text
        val recyclerView = recycler_view_jokes

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        jokeAdapter = JokeListAdapter(this)

        resultsButton.setOnClickListener {
            reload(input = editText.text, adapter = jokeAdapter)
        }

    }
}
