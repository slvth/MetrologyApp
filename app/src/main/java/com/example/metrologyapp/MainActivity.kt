package com.example.metrologyapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.metrologyapp.databinding.ActivityMainBinding
import com.example.metrologyapp.fragment.AccountFragment
import com.example.metrologyapp.fragment.GraphFragment
import com.example.metrologyapp.fragment.theory.CourseFragment
import com.example.metrologyapp.fragment.theory.CourseFragmentDirections
import com.example.metrologyapp.fragment.theory.ModuleFragmentDirections
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val theoryFragment = CourseFragment()
        val graphFragment = GraphFragment()
        val accountFragment = AccountFragment()


        //makeCurrentFragment(theoryFragment)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.containerTheory) as NavHostFragment
        navController = navHostFragment.navController

        val navView: BottomNavigationView = findViewById(R.id.buttom_nav_view);
        binding.buttomNavView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.courseFragment -> {
                    Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
                }
                R.id.graphFragment -> {
                    Toast.makeText(this, "2", Toast.LENGTH_SHORT).show()
                    return@setOnItemSelectedListener true
                }
                R.id.accountFragment -> {
                    Toast.makeText(this, "3", Toast.LENGTH_SHORT).show()
                    return@setOnItemSelectedListener true
                }
            }
            return@setOnItemSelectedListener false
        }

        binding.buttomNavView.setupWithNavController(navController)
    }

    fun makeCurrentFragment(fragment: Fragment){
        //val action = ModuleFragmentDirections.actionModuleFragmentToCourseFragment()
        //navController.navigate(action)

        Toast.makeText(this, "fsefsefsef", Toast.LENGTH_SHORT).show()
        /*
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout,fragment)
            commit()
        }*/
    }

}