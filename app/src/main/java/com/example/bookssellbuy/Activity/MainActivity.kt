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

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.fragmentContainer)
        binding.bottomMenu.setupWithNavController(navController)

        hideNavBarforperticularfragment(navController)
    }

    private fun hideNavBarforperticularfragment(navController: NavController) {
        val materialToolbar2: Toolbar = findViewById(R.id.materialToolbar2)
        setSupportActionBar(materialToolbar2)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.accountFragment -> materialToolbar2.visibility = View.GONE
                else -> materialToolbar2.visibility = View.VISIBLE
            }
        }
    }
}
