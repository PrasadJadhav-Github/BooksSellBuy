package com.example.bookssellbuy.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.bookssellbuy.R
import com.example.bookssellbuy.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)

        // Set up click listeners for card views
        cardListener()


        return binding.root
    }



    //categoory card view button listeners
    private fun cardListener() {
        binding.cardviewOneToTen.setOnClickListener {
            findNavController().navigate(R.id.action_categoryFragment_to_fragment_one_to_ten)
        }
        binding.cardviewElevenToTwelve.setOnClickListener {
            findNavController().navigate(R.id.action_categoryFragment_to_fragment_eleven_to_twelve)
        }
        binding.cardviewGraduation.setOnClickListener {
            findNavController().navigate(R.id.action_categoryFragment_to_fragment_Graduation)
        }
        binding.cardviewEngineering.setOnClickListener {
            findNavController().navigate(R.id.action_categoryFragment_to_fragment_Engineering)
        }

    }


}
