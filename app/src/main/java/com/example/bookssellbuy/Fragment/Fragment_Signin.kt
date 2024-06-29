package com.example.bookssellbuy.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.bookssellbuy.R
import com.example.bookssellbuy.databinding.FragmentSigninBinding
import com.google.firebase.auth.FirebaseAuth

class Fragment_Signin : Fragment() {
    private lateinit var binding: FragmentSigninBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSigninBinding.inflate(inflater, container, false)
        firebaseAuth = FirebaseAuth.getInstance()
        onSigninButtonClick()
        return binding.root
    }

    private fun onSigninButtonClick() {
        binding.signupButton.setOnClickListener {
            val email = binding.edtusername.text.toString()
            val password = binding.edtpassword.text.toString()
            val confirmpassword = binding.edtconfirmpassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && confirmpassword.isNotEmpty()) {
                if (password == confirmpassword) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                findNavController().navigate(R.id.action_fragment_Signin_to_fragment_WelcomeScreen)
//                                val intent = Intent(requireContext(), Accounts_Fragment::class.java)
//                                startActivity(intent)
//                                requireActivity().finish()
                            } else {
                                Toast.makeText(
                                    requireContext(),
                                    it.exception.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Password is not matching",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    requireContext(),
                    "Empty fields are not allowed",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }
}
