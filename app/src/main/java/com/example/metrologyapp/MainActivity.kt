package com.example.metrologyapp

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.metrologyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    lateinit var binding: ActivityMainBinding

    private var currentNavController : LiveData<NavController>?=null

    private var onDestinationChangedListener =
        NavController.OnDestinationChangedListener{ controller, destination, arguments ->
            //binding.bottomNavigationView.isVisible = destination.id != R.id.moduleFragment
        }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null)
            setUpBottomNavigationBar()
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setUpBottomNavigationBar()
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun setUpBottomNavigationBar() {
        val navGraphIds = listOf(
            R.navigation.nav_theory,
            R.navigation.nav_graph,
            R.navigation.nav_account
        )

        val controller = binding.bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.containerTheory,
            intent = intent
        )

        controller.observe(this){ navController ->
            //setupActionBarWithNavController(navController)
            currentNavController?.value?.removeOnDestinationChangedListener(
                onDestinationChangedListener
            )
            navController.addOnDestinationChangedListener(onDestinationChangedListener)
        }

        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }
}