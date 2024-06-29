package com.example.bookssellbuy.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bookssellbuy.R
import com.example.bookssellbuy.databinding.FragmentWelcomeScreenBinding
import com.google.firebase.auth.FirebaseAuth

class Fragment_WelcomeScreen : Fragment() {

    private lateinit var binding: FragmentWelcomeScreenBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeScreenBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment


        firebaseAuth = FirebaseAuth.getInstance()
        setupWelcomeMessage()
        onLogoutButtonClick()


        return binding.root
    }


    private fun onLogoutButtonClick(){
        binding.logoutButton.setOnClickListener {
            firebaseAuth.signOut()
            findNavController().navigate(R.id.accountFragment)
        }
    }
    private fun setupWelcomeMessage() {
        val currentUser = firebaseAuth.currentUser
        currentUser?.let {
            val welcomeMessage = "Welcome, ${it.email}!"
            binding.welcomeusername.text = welcomeMessage
        }
    }
}
