package ru.slavicsky.chuckjokesapp.view.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
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
import ru.slavicsky.chuckjokesapp.view.adapters.Adapter
import java.io.Serializable


class JokesFragment : Fragment() {

    private lateinit var pref: SharedPreferences
    private val TAG = "myLogs"
    private lateinit var adapter: Adapter
    private var jokes : MutableList<JokeResponse> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = context?.let(::Adapter)!!
        Log.d(TAG, "onCreate")
        adapter.jokes = jokes
    }

    @Override
    override fun onActivityCreated(savedInstanceState : Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated")
        savedInstanceState?.putSerializable("list state", adapter.jokes as Serializable)
    }

    override fun onPause() {
        Log.d(TAG, "In onsave")
        jokes = adapter.jokes
        println(jokes)
        super.onPause()
    }

    override fun onResume() {
        super.onResume()

        Log.d(TAG, "In onResume")
        println(jokes)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(TAG, "onViewStateRestored")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        val root = inflater.inflate(R.layout.fragment_jokes, container, false)
        val recyclerView = root.findViewById(R.id.jokes_list) as RecyclerView
        val layoutManager = WrapContentLinearLayoutManager(this.context)
        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = adapter

        val resultsButton = root.findViewById(R.id.button_results) as Button
        val editText = root.findViewById(R.id.search_field) as EditText

        resultsButton.setOnClickListener {
            resultsButton.reload(editText.text, adapter)
            Log.d(TAG, "button pressed")
        }
        return root
    }
}




