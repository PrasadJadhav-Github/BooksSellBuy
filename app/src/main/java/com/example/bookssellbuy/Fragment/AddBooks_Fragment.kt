package com.example.bookssellbuy.Fragment

import BookInfo
import android.app.Activity
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
import com.google.firebase.storage.FirebaseStorage
import java.util.UUID


class AddBooks_Fragment : Fragment() {
    private lateinit var binding: FragmentAddBooksBinding
    private lateinit var database: DatabaseReference
    private lateinit var storage: FirebaseStorage
    private var selectedImageUri: Uri? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBooksBinding.inflate(inflater, container, false)
        setAutoCompleteTextView()
        onSubmitButtonClick()
        onSelectedImageClick()
        storage = FirebaseStorage.getInstance()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun onSelectedImageClick() {
        binding.buttonSelectImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_CODE_SELECT_IMAGE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SELECT_IMAGE && resultCode == Activity.RESULT_OK) {
            selectedImageUri = data?.data
            binding.imageViewBookCover.setImageURI(selectedImageUri)
        }
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

            // Check if any of the required fields are empty
            if (bookname.isEmpty() || bookprice.isEmpty() || bookdescription.isEmpty() || bookyear.isEmpty()
                || bookcategory.isEmpty() || mobilenumber.isEmpty() || bookstandard.isEmpty()
            ) {
                Toast.makeText(
                    requireContext(),
                    "Empty Fields are not allowed.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // Check if an image has been selected
            if (selectedImageUri == null) {
                Toast.makeText(requireContext(), "Please select an image", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            // Upload the image and save the book data to Firebase
            uploadImageAndSaveData(
                bookname,
                bookprice,
                bookdescription,
                bookcategory,
                bookstandard,
                bookyear,
                mobilenumber
            )
        }
    }

    private fun uploadImageAndSaveData(
        bookname: String,
        bookprice: String,
        bookdescription: String,
        bookcategory: String,
        bookstandard: String,
        bookyear: String,
        mobilenumber: String
    ) {
        val filename = UUID.randomUUID().toString()
        val ref = storage.getReference("/images/$filename")

        selectedImageUri?.let {
            ref.putFile(it)

                .addOnSuccessListener { taskSnapshot ->
                    ref.downloadUrl.addOnSuccessListener { uri ->
                        saveBookInfoToDatabase(bookname, bookprice, bookdescription, bookcategory, bookstandard, bookyear, mobilenumber, uri.toString())
                    }
                }

                .addOnFailureListener {
                    Toast.makeText(requireContext(), "Failed to uplad an image", Toast.LENGTH_SHORT)
                        .show()

                }
        }

    }


    private fun saveBookInfoToDatabase(bookname: String,bookprice: String,bookdescription: String,
                                       bookcategory: String,bookstandard: String,bookyear: String,mobilenumber: String,imageUrl: String) {

        database =FirebaseDatabase.getInstance().getReference("BookInfo")
        val  bookInfo=BookInfo(bookname,bookprice,bookdescription,bookcategory,bookstandard,bookyear,mobilenumber,imageUrl)
        database.child(bookname).setValue(bookInfo).addOnSuccessListener {
            binding.edittextBookName.text?.clear()
            binding.editTextBookPrice.text?.clear()
            binding.editTextBookDescription.text?.clear()
            binding.edittextBookCategory.text?.clear()
            binding.edittextBookStandard.text?.clear()
            binding.editTextBookYear.text?.clear()
            binding.editTextMobileNumber.text?.clear()
            binding.imageViewBookCover.setImageURI(null)
            Toast.makeText(requireContext(), "Book added successfully", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(requireContext(), "Failed to add book", Toast.LENGTH_SHORT).show()
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


        val graduationAdapter = ArrayAdapter(
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
                        Toast.makeText(requireContext(), "Selected: 1 to 10", Toast.LENGTH_SHORT)
                            .show()
                    }

                    "11 to 12" -> {
                        edittextBookStandard.setAdapter(eleventotwelveAdapter)
                        Toast.makeText(requireContext(), "Selected: 11 to 12", Toast.LENGTH_SHORT)
                            .show()
                    }

                    "Graduation" -> {
                        edittextBookStandard.setAdapter(graduationAdapter)
                        Toast.makeText(requireContext(), "Selected: Graduation", Toast.LENGTH_SHORT)
                            .show()
                    }

                    "Engineering" -> {
                        edittextBookStandard.setAdapter(engineeringAdapter)
                        Toast.makeText(
                            requireContext(),
                            "Selected: Engineering",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    else -> {
                        Toast.makeText(requireContext(), "Invalid category", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

    companion object {
        private const val REQUEST_CODE_SELECT_IMAGE = 1001
    }
}
