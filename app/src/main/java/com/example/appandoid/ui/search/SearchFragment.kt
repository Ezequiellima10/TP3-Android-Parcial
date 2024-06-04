package com.example.appandoid.ui.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appandoid.R
import com.example.appandoid.adapters.RecViewAdapterOffers
import com.example.appandoid.databinding.FragmentSearchBinding
import com.example.appandoid.providers.CardProvider
import com.google.android.material.textfield.TextInputLayout
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.Locale


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        initRecycleView()
        binding.searchBtn.setOnClickListener{
            if(validateForm()){
                resetForm()
                this.findNavController().navigate(R.id.action_searchFragment_to_resultsFragment)
            }
        }
        return binding.root
    }

    private fun validateForm():Boolean {
        val dateTxt = binding.dateInput.text.toString()
        val depTxt = binding.departureInput.text.toString()
        val arrvTxt = binding.arrivalInput.text.toString()
        val psngrTxt = binding.passengrInput.text.toString()
        val clasTxt = binding.classInput.text.toString()
        var re = false

        if(validateInput(depTxt,binding.departureTxt) && validateInput(arrvTxt,binding.arrivalTxt)
            && validateDate(dateTxt, binding.datePicker)  && validateInput(psngrTxt, binding.classPicker)
            && validateInput(clasTxt,binding.classPicker)){
            Toast.makeText(requireContext(), "Form submitted correctly", Toast.LENGTH_SHORT).show()
            re  = true
        }
        return re
    }
    private fun validateInput(input: String, layout: TextInputLayout): Boolean {
        return if (input.isEmpty()) {
            layout.error = "RequiredField"
            false
        } else {
            layout.error = null
            true
        }
    }


    private fun validateDate(dateStr: String, layout: TextInputLayout): Boolean {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH)
        return try {
            val inputDate = LocalDate.parse(dateStr, formatter)
            val today = LocalDate.now()
            Log.i("DateValidation", "Parsed date: $inputDate")  // Add logging for debugging
            if (inputDate.isBefore(today)) {
                layout.error = "Date must be the same or later than today"
                false
            } else {
                layout.error = null
                true
            }
        } catch (e: DateTimeParseException) {
            Log.e("DateValidation", "Invalid date format", e)  // Log exception for debugging
            layout.error = "Invalid date format. Please use dd/MM/yyyy."
            false
        }
    }


    private fun resetForm()
    {
        var message = "Departure: " + binding.departureInput.text
        message += "Arrival: " + binding.arrivalInput.text
        message += "Departure Date: " + binding.dateInput.text
        message += "Passengers: " + binding.passengrInput.text
        message += "Flight class: " + binding.classInput.text
        AlertDialog.Builder(requireContext())
            .setTitle("Form submitted correctly")
            .setMessage(message)
            .setPositiveButton("Okay"){ _,_ ->
                binding.departureInput.text = null
                binding.arrivalInput.text= null
                binding.dateInput.text = null
                binding.passengrInput.text = null
                binding.classInput.text = null
            }
            .show()
    }

    private fun initRecycleView(){
        val adapter = RecViewAdapterOffers(CardProvider.imagesList)
        binding.offersRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.offersRv.adapter = adapter
    }

}