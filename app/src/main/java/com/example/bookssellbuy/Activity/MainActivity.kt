package com.example.bookssellbuy.Activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bookssellbuy.R
import com.example.bookssellbuy.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //2 line use for set bottom navigation
        val navController = findNavController(R.id.fragmentContainer)
        binding.bottomMenu.setupWithNavController(navController)

        //function Call
        setupToolbarVisibility(navController)
        hidetoolbarforwelcomescreen(navController)

    }

    private fun setupToolbarVisibility(navController: NavController) {
        val materialToolbar2: Toolbar = findViewById(R.id.materialToolbar2)
        setSupportActionBar(materialToolbar2)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.accountFragment, R.id.fragment_Signin -> {
                    materialToolbar2.visibility = View.GONE
                    binding.bottomMenu.visibility =
                        View.GONE // Optionally hide bottom navigation
                }

                else -> {
                    materialToolbar2.visibility = View.VISIBLE
                    binding.bottomMenu.visibility =
                        View.VISIBLE // Show bottom navigation for other fragments
                }
            }
        }
    }


    private fun hidetoolbarforwelcomescreen(navController: NavController) {
        val materialToolbar2: Toolbar = findViewById(R.id.materialToolbar2)
        setSupportActionBar(materialToolbar2)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.fragment_WelcomeScreen -> {
                    materialToolbar2.visibility = View.GONE
//                    binding.bottomMenu.visibility =
//                        View.GONE // Optionally hide bottom navigation
                }

                else -> {
                    materialToolbar2.visibility = View.VISIBLE
                    binding.bottomMenu.visibility =
                        View.VISIBLE // Show bottom navigation for other fragments
                }
            }
        }
    }
}

