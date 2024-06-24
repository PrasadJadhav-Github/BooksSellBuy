package com.example.bookssellbuy.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bookssellbuy.R
import com.example.bookssellbuy.databinding.FragmentAddBooksBinding

class AddBooks_Fragment : Fragment() {
    private lateinit var binding: FragmentAddBooksBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentAddBooksBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_books_, container, false)
    }


}