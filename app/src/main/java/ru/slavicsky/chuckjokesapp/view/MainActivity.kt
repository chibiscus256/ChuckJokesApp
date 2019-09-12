package ru.slavicsky.chuckjokesapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.slavicsky.chuckjokesapp.R
import ru.slavicsky.chuckjokesapp.components.WrapContentLinearLayoutManager
import ru.slavicsky.chuckjokesapp.utils.FragmentStateHelper
import ru.slavicsky.chuckjokesapp.view.adapters.JokeListAdapter

class MainActivity : AppCompatActivity() {

    companion object {
        private const val STATE_SAVE_STATE = "save_state"
    }

    private lateinit var jokeAdapter: JokeListAdapter
    private lateinit var stateHelper: FragmentStateHelper
    private val fragments = mutableMapOf<Int, Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = this.findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        AppBarConfiguration(setOf(R.id.navigation_jokes, R.id.navigation_web)).
            apply { setupActionBarWithNavController(navController, this) }
        navView.setupWithNavController(navController)
    }
}