package com.example.bookssellbuy.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return binding.root
    }

}