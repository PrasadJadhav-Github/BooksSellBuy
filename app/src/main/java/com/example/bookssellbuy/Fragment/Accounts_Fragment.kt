package com.example.bookssellbuy.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.bookssellbuy.R
import com.example.bookssellbuy.databinding.FragmentAccountsBinding
import com.google.firebase.auth.FirebaseAuth

class Accounts_Fragment : Fragment() {

    private lateinit var binding: FragmentAccountsBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountsBinding.inflate(inflater, container, false)
        firebaseAuth = FirebaseAuth.getInstance()

        signup()
        onLoginButtonClick()
        checkUserLoggedInState()
        return binding.root
    }


    private fun onLoginButtonClick() {
        binding.loginButton.setOnClickListener {
            val email = binding.username.text.toString()
            val password = binding.password.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        // Navigate to HomeFragment after successful login
                        findNavController().navigate(R.id.action_accountFragment_to_homeFragment)
                    } else {
                        Toast.makeText(
                            requireContext(), it.exception.toString(), Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } else {
                Toast.makeText(
                    requireContext(), "Empty fields are not allowed", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun signup() {
        binding.signupText.setOnClickListener {
            findNavController().navigate(R.id.action_accountFragment_to_fragment_Signin)
        }
    }

    private fun checkUserLoggedInState() {
        val currentUser = firebaseAuth.currentUser
        if (currentUser != null) {
            // User is logged in, navigate to WelcomeFragment
            findNavController().navigate(R.id.action_accountFragment_to_fragment_WelcomeScreen)
        }
        // No need to handle else case here because you want to stay on AccountFragment
        // and show login options if user is not logged in
    }

}