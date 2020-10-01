package ru.slavicsky.chuckjokesapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.button_and_edittext.*
import ru.slavicsky.chuckjokesapp.MainActivity
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

    private val jokesViewModel: JokesViewModel by activityViewModels()
    private var binding: FragmentJokesBinding by autoCleared()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity).titleMain.text = getString(R.string.title_jokes)
        binding = FragmentJokesBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.jokesList.layoutManager = LinearLayoutManager(requireContext())

        observe(jokesViewModel.fetchedJokes, ::handleList)

        btn_results.setOnClickListener {
            val jokesNumber = btn_results.checkInput(et_search.text)
            if (btn_results.checkInput(et_search.text) < 300) jokesViewModel.requestJokes(jokesNumber)
        }
    }

    private fun bindListData(breedsResponse: List<Joke>) {
        if (!breedsResponse.isNullOrEmpty()) {
            val jokesAdapter = JokesAdapter()
            binding.jokesList.adapter = jokesAdapter
            jokesAdapter.loadlist(breedsResponse)
            showDataView(true)
        } else {
            showDataView(false)
        }
    }

    private fun showLoadingView() {
        binding.pbLoading.toVisible()
        binding.tvNoData.toGone()
        binding.jokesList.toGone()
    }

    private fun showDataView(show: Boolean) {
        binding.pbLoading.toGone()
        binding.jokesList.visibility = if (show) VISIBLE else GONE
        binding.tvNoData.visibility = if (show) GONE else View.VISIBLE
    }

    private fun handleList(response: Resource<List<Joke>>) {
        when (response) {
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> response.data?.let { bindListData(breedsResponse = it) }
            is Resource.DataError -> showDataView(false)
        }
    }
}



