package com.example.bookssellbuy.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bookssellbuy.R
import com.example.bookssellbuy.databinding.FragmentElevenToTwelveBinding


class Fragment_eleven_to_twelve : Fragment() {
   private lateinit var binding :FragmentElevenToTwelveBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentElevenToTwelveBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        onbuttonclick()
       return binding.root
    }


    private  fun onbuttonclick(){
        binding.science11th.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_eleven_to_twelve_to_fragment_11thscience)
        }

        binding.commerce11th.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_eleven_to_twelve_to_fragment_11thcommerce)
        }


        binding.arts11th.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_eleven_to_twelve_to_fragment_11tharts)
        }

        binding.science12th.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_eleven_to_twelve_to_fragment_12thscience)
        }


        binding.commerce12th.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_eleven_to_twelve_to_fragment_12thcommerce)
        }


        binding.arts12th.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_eleven_to_twelve_to_fragment_12tharts)
        }
    }

}