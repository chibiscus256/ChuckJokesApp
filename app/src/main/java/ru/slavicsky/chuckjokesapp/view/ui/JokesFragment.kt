package ru.slavicsky.chuckjokesapp.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ru.slavicsky.chuckjokesapp.R
import ru.slavicsky.chuckjokesapp.components.WrapContentLinearLayoutManager
import ru.slavicsky.chuckjokesapp.models.JokeResponse
import ru.slavicsky.chuckjokesapp.utils.extensions.reload
import ru.slavicsky.chuckjokesapp.view.adapters.JokeListAdapter

class JokesFragment : Fragment() {
    private lateinit var jokeAdapter: JokeListAdapter
    lateinit var jokes: List<JokeResponse>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        jokeAdapter = context?.let { JokeListAdapter(it) }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_jokes, container, false)
        val recyclerView = root.findViewById(R.id.recycler_view_jokes) as RecyclerView
        val layoutManager = WrapContentLinearLayoutManager(this.context)
        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = jokeAdapter

        val resultsButton = root.findViewById(R.id.results_button) as Button
        val editText = root.findViewById(R.id.search_text) as EditText

        resultsButton.setOnClickListener {
            resultsButton.reload(input = editText.text, adapter = jokeAdapter)
        }
        return root
    }
}


