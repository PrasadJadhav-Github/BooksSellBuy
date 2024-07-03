package com.example.bookssellbuy.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bookssellbuy.R
import com.example.bookssellbuy.databinding.FragmentGraduationBinding


class Fragment_Graduation : Fragment() {
    private  lateinit var binding:FragmentGraduationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentGraduationBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        onbuttonClick()
        return  binding.root
    }

    private  fun onbuttonClick(){
        binding.btnBSCit.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Graduation_to_fragment_BSCIT)
        }

        binding.btnBSCcs.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Graduation_to_fragment_BSCCS)
        }

        binding.btnBCOM.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Graduation_to_fragment_BCOM)
        }

        binding.btnBMS.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Graduation_to_fragment_BMS)
        }

        binding.btnBSCChemistry.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Graduation_to_fragment_BSC_Chemistry)
        }

        binding.btnBSCBotney.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_Graduation_to_fragment_BSC_Botney)
        }
    }

}