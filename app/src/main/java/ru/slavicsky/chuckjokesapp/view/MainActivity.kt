package ru.slavicsky.chuckjokesapp.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.slavicsky.chuckjokesapp.R
import ru.slavicsky.chuckjokesapp.utils.extensions.addFragment
import ru.slavicsky.chuckjokesapp.utils.extensions.replaceFragment
import ru.slavicsky.chuckjokesapp.view.ui.JokesFragment.Companion.newInstance


class MainActivity : AppCompatActivity() {

    private lateinit var mContent: Fragment

    companion object {
        private const val SAVE_STATE = "save_state"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = this.findViewById(R.id.navigation_view)
        val navController = findNavController(R.id.nav_host_fragment)
        savedInstanceState?.getBundle(SAVE_STATE)
        val mContent =
            savedInstanceState?.let { supportFragmentManager.getFragment(it, SAVE_STATE) }

        AppBarConfiguration(
            setOf(
                R.id.navigation_jokes,
                R.id.navigation_web
            )
        ).apply { setupActionBarWithNavController(navController, this) }
        navView.setupWithNavController(navController)

        if (savedInstanceState != null) {
            val jokesFragment = newInstance()
            replaceFragment(jokesFragment, R.id.fragment_container)
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        supportFragmentManager.putFragment(outState, SAVE_STATE, mContent)
        super.onSaveInstanceState(outState, outPersistentState)
    }

}