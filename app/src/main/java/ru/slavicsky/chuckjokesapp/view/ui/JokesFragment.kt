package ru.slavicsky.chuckjokesapp.view.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.button_and_edittext.*
import kotlinx.android.synthetic.main.fragment_jokes.*
import ru.slavicsky.chuckjokesapp.R
import ru.slavicsky.chuckjokesapp.databinding.FragmentJokesBinding
import ru.slavicsky.chuckjokesapp.model.repo.JokeRepository
import ru.slavicsky.chuckjokesapp.utils.extensions.checkInput
import ru.slavicsky.chuckjokesapp.view.adapters.JokesAdapter
import ru.slavicsky.chuckjokesapp.viewmodel.JokesViewModel

class JokesFragment : Fragment() {

    lateinit var binding: FragmentJokesBinding

    companion object {
        fun newInstance() = JokesFragment()
    }

    private val TAG = "myLogs"
    private lateinit var jokesViewModel: JokesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")

        return inflater.inflate(R.layout.fragment_jokes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding: FragmentJokesBinding? = DataBindingUtil.bind(view)
        val resultsButton = button_results as Button
        val editText = search_field as EditText

        jokesViewModel = ViewModelProviders.of(this).get(JokesViewModel::class.java)

        resultsButton.setOnClickListener {
            val jokesNumber = resultsButton.checkInput(editText.text)
            if (jokesNumber < 300) jokesViewModel.requestJokes(jokesNumber)
            Log.d(TAG, "button pressed")
        }

        initRecycler()
    }


    private fun initRecycler(){
        val adapter = JokesAdapter()
        jokes_list.layoutManager = LinearLayoutManager(activity)
        jokes_list.adapter = adapter

        jokesViewModel.getJokesLiveData().observe(this, Observer {
            adapter.loadlist(it)
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}



