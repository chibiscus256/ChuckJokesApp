package ru.slavicsky.chuckjokesapp.view.ui

import ru.slavicsky.chuckjokesapp.R

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class WebFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_web, container, false)

        val textView: TextView = root.findViewById(R.id.text_web)
        notificationsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}