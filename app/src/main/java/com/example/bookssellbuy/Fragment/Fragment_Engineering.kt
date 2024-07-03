package com.example.bookssellbuy.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bookssellbuy.R
import com.example.bookssellbuy.databinding.FragmentEngineeringBinding

class Fragment_Engineering : Fragment() {
    private lateinit var binding:FragmentEngineeringBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentEngineeringBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        onbuttonClick()
       return  binding.root
    }

    private  fun onbuttonClick(){
        binding.btnCivil.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Engineering_to_fragment_Civil)
        }

        binding.btnElectrical.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Engineering_to_fragment_Electrical)
        }

        binding.btnElectronic.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Engineering_to_fragment_Electronic)
        }

        binding.btnMechanical.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Engineering_to_fragment_Mechanical)
        }

        binding.btnInformationTechnology.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Engineering_to_fragment_InformationTechnology)
        }


    }
}