package com.example.metrologyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.metrologyapp.databinding.ActivityMainBinding
import com.example.metrologyapp.fragment.AccountFragment
import com.example.metrologyapp.fragment.GraphFragment
import com.example.metrologyapp.fragment.TheoryFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val theoryFragment = TheoryFragment()
        val graphFragment = GraphFragment()
        val accountFragment = AccountFragment()

        makeCurrentFragment(theoryFragment)

        binding.buttomNavView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.navigation_theory -> makeCurrentFragment(theoryFragment)
                R.id.navigation_graph -> makeCurrentFragment(graphFragment)
                R.id.navigation_account -> makeCurrentFragment(accountFragment)
            }
            true
        }

        //val navView: BottomNavigationView = findViewById(R.id.buttom_nav_view);
    }

    private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout,fragment)
            commit()
        }
    }
}