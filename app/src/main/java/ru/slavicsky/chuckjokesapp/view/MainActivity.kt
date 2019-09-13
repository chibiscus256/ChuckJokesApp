package ru.slavicsky.chuckjokesapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.slavicsky.chuckjokesapp.R

class MainActivity : AppCompatActivity() {

    companion object {
        private const val STATE_SAVE_STATE = "save_state"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = this.findViewById(R.id.navigation_view)
        val navController = findNavController(R.id.nav_host_fragment)
        savedInstanceState?.getBundle("save_state")

        AppBarConfiguration(
            setOf(
                R.id.navigation_jokes,
                R.id.navigation_web
            )
        ).apply { setupActionBarWithNavController(navController, this) }
        navView.setupWithNavController(navController)
    }

}