package ru.slavicsky.chuckjokesapp.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.button_and_edittext.*
import ru.slavicsky.chuckjokesapp.R
import ru.slavicsky.chuckjokesapp.models.JokeResponse
import ru.slavicsky.chuckjokesapp.utils.extensions.reload
import ru.slavicsky.chuckjokesapp.view.adapters.JokeListAdapter

class JokesFragment : Fragment() {

    lateinit var jokes: List<JokeResponse>
    private lateinit var jokeAdapter: JokeListAdapter
    private lateinit var jokesViewModel: JokesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        jokesViewModel = ViewModelProviders.of(this).get(JokesViewModel::class.java)
        super.onCreate(savedInstanceState)

        val root = inflater.inflate(R.layout.fragment_jokes, container, false)

        val resultsButton = root.findViewById(R.id.results_button) as Button
        val editText = root.findViewById(R.id.search_text) as EditText
        val recyclerView = root.findViewById(R.id.recycler_view_jokes) as RecyclerView

        val layoutManager = LinearLayoutManager(this.context)
        recyclerView.layoutManager = layoutManager

        jokeAdapter = context?.let { JokeListAdapter(it) }!!
        recyclerView.adapter = jokeAdapter

        resultsButton.setOnClickListener {
            reload(input = editText.text, adapter = jokeAdapter)
        }

        return root
    }
}
