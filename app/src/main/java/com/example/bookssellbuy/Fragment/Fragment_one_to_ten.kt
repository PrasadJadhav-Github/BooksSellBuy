package com.example.bookssellbuy.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bookssellbuy.R
import com.example.bookssellbuy.databinding.FragmentOneToTenBinding


class Fragment_one_to_ten : Fragment() {

    private lateinit var binding : FragmentOneToTenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentOneToTenBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        onbuttonclick()
        return binding.root
    }

    private  fun onbuttonclick(){
        binding.buttonstandard1.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_one_to_ten_to_fragment_1stStandard)
        }
        binding.buttonstandard2.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_one_to_ten_to_fragment_2ndStandard)
        }
        binding.buttonstandard3.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_one_to_ten_to_fragment_3rdStandard)
        }
        binding.buttonstandard4.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_one_to_ten_to_fragment_4thStandard)
        }
        binding.buttonstandard5.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_one_to_ten_to_fragment_5thStandard)
        }
        binding.buttonstandard6.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_one_to_ten_to_fragment_6thStandard)
        }
        binding.buttonstandard7.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_one_to_ten_to_fragment_7thStandard)
        }
        binding.buttonstandard8.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_one_to_ten_to_fragment_8thStandard)
        }
        binding.buttonstandard9.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_one_to_ten_to_fragment_9thStandard)
        }
        binding.buttonstandard10.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_one_to_ten_to_fragment_10thStandard)
        }

    }

}