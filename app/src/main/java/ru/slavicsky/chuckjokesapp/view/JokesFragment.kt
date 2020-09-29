package ru.slavicsky.chuckjokesapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.button_and_edittext.*
import kotlinx.android.synthetic.main.fragment_jokes.*
import ru.slavicsky.chuckjokesapp.R
import ru.slavicsky.chuckjokesapp.data.Resource
import ru.slavicsky.chuckjokesapp.databinding.FragmentJokesBinding
import ru.slavicsky.chuckjokesapp.model.Joke
import ru.slavicsky.chuckjokesapp.utils.autoCleared
import ru.slavicsky.chuckjokesapp.utils.extensions.checkInput
import ru.slavicsky.chuckjokesapp.utils.extensions.observe
import ru.slavicsky.chuckjokesapp.utils.extensions.toGone
import ru.slavicsky.chuckjokesapp.utils.extensions.toVisible
import ru.slavicsky.chuckjokesapp.view.adapters.JokesAdapter
import ru.slavicsky.chuckjokesapp.viewmodel.JokesViewModel

@AndroidEntryPoint
class JokesFragment : Fragment() {

    companion object {
        fun newInstance() = JokesFragment()
    }

    val jokesViewModel: JokesViewModel by activityViewModels()
    var binding: FragmentJokesBinding by autoCleared()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJokesBinding.inflate(
            inflater,
            container,
            false
        )
        context ?: return binding.root
        observe(jokesViewModel.fetchedJokes, ::handleList)
        return inflater.inflate(R.layout.fragment_jokes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resultsButton = button_results as Button
        val editText = search_field as EditText

        resultsButton.setOnClickListener {
            val jokesNumber = resultsButton.checkInput(editText.text)
            if (jokesNumber < 300) jokesViewModel.requestJokes(jokesNumber)
        }
        initRecycler()
    }

    private fun bindListData(breedsResponse: List<Joke>) {
        if (!breedsResponse.isNullOrEmpty()) {
            val breedsAdapter = JokesAdapter()
            binding.jokesList.adapter = breedsAdapter
            showDataView(true)
        } else {
            showDataView(false)
        }
    }

    internal fun showLoadingView() {
        binding.pbLoading.toVisible()
        binding.tvNoData.toGone()
    }

    private fun showDataView(show: Boolean) {
        binding.pbLoading.toGone()
        binding.tvNoData.visibility = if (show) View.GONE else View.VISIBLE
    }

    private fun initRecycler() {
        jokes_list.layoutManager = LinearLayoutManager(activity)
    }

    private fun handleList(response: Resource<List<Joke>>) {
        when (response) {
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> response.data?.let { bindListData(breedsResponse = it) }
            is Resource.DataError -> showDataView(false)
        }
    }
}



