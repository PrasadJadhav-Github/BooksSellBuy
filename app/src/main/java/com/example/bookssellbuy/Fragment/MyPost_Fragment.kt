package com.example.bookssellbuy.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bookssellbuy.databinding.FragmentMypostBinding

class MyPost_Fragment : Fragment() {
    private lateinit var binding: FragmentMypostBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentMypostBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

}