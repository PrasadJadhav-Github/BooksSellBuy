package com.example.bookssellbuy.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bookssellbuy.R
import com.example.bookssellbuy.databinding.FragmentCategoryBinding

class Category_Fragment : Fragment() {

    private  lateinit var  binding: FragmentCategoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCategoryBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

}