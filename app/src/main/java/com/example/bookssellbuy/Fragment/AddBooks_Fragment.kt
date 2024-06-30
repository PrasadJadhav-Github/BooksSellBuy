package com.example.bookssellbuy.Fragment

import BookInfo
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.bookssellbuy.Object_File.Category
import com.example.bookssellbuy.R
import com.example.bookssellbuy.databinding.FragmentAddBooksBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class AddBooks_Fragment : Fragment() {
    private lateinit var binding: FragmentAddBooksBinding
    private lateinit var database: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBooksBinding.inflate(inflater, container, false)
        setAutoCompleteTextView()
        onSubmitButtonClick()
        // Inflate the layout for this fragment
        return binding.root
    }


    private fun onSubmitButtonClick() {
        binding.buttonAddBook.setOnClickListener {
            val bookname = binding.edittextBookName.text.toString()
            val bookprice = binding.editTextBookPrice.text.toString()
            val bookdescription = binding.editTextBookDescription.text.toString()
            val bookcategory = binding.edittextBookCategory.text.toString()
            val bookstandard = binding.edittextBookStandard.text.toString()
            val bookyear = binding.editTextBookYear.text.toString()
            val mobilenumber = binding.editTextMobileNumber.text.toString()


            if (bookname.isEmpty() || bookprice.isEmpty() || bookdescription.isEmpty() || bookyear.isEmpty()
                || bookcategory.isEmpty() || mobilenumber.isEmpty() || bookstandard.isEmpty()
            ) {
                Toast.makeText(
                    requireContext(),
                    "Empty Fields are not allowed.",
                    Toast.LENGTH_SHORT
                ).show()
            }


            database = FirebaseDatabase.getInstance().getReference("BookInfo")
            val bookinfo =
                BookInfo(bookname, bookprice, bookdescription, bookcategory,bookstandard, bookyear, mobilenumber)
            database.child(bookname).setValue(bookinfo).addOnSuccessListener {
                binding.edittextBookName.text?.clear()
                binding.editTextBookPrice.text?.clear()
                binding.editTextBookDescription.text?.clear()
                binding.edittextBookCategory.text?.clear()
                binding.edittextBookStandard.text?.clear()
                binding.editTextBookYear.text?.clear()
                binding.editTextMobileNumber.text?.clear()

                Toast.makeText(requireContext(), "Book Added Successfully...", Toast.LENGTH_SHORT)
                    .show()

            }.addOnFailureListener {
                Toast.makeText(
                    requireContext(),
                    "Failed.../Something went wrong",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }


    private fun setAutoCompleteTextView() {

        val fieldsAdapter = ArrayAdapter(
            requireContext(),
            R.layout.show_list,
            Category.fields
        )
        val onetotenAdapter = ArrayAdapter(
            requireContext(),
            R.layout.show_list,
            Category.oneToTen
        )

        val eleventotwelveAdapter = ArrayAdapter(
            requireContext(),
            R.layout.show_list,
            Category.elevenToTwelve
        )


        val graduationAdapter=ArrayAdapter(
            requireContext(),
            R.layout.show_list,
            Category.graduation
        )
        val engineeringAdapter = ArrayAdapter(
            requireContext(),
            R.layout.show_list,
            Category.engineering
        )


        binding.apply {
            edittextBookCategory.setAdapter(fieldsAdapter)
            edittextBookCategory.setOnItemClickListener { parent, view, position, id ->
                val selectedCategory = fieldsAdapter.getItem(position)
                when (selectedCategory) {
                    "1 to 10" -> {
                        edittextBookStandard.setAdapter(onetotenAdapter)
                        Toast.makeText(requireContext(), "Selected: 1 to 10", Toast.LENGTH_SHORT).show()
                    }

                    "11 to 12" -> {
                        edittextBookStandard.setAdapter(eleventotwelveAdapter)
                        Toast.makeText(requireContext(), "Selected: 11 to 12", Toast.LENGTH_SHORT).show()
                    }

                    "Graduation" -> {
                        edittextBookStandard.setAdapter(graduationAdapter)
                        Toast.makeText(requireContext(), "Selected: Graduation", Toast.LENGTH_SHORT).show()
                    }

                    "Engineering" -> {
                        edittextBookStandard.setAdapter(engineeringAdapter)
                        Toast.makeText(requireContext(), "Selected: Engineering", Toast.LENGTH_SHORT).show()
                    }

                    else -> {
                        Toast.makeText(requireContext(), "Invalid category", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
    }
