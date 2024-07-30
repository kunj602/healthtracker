package com.example.healthtracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class HealthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_health, container, false)

        val nameEditText: EditText = view.findViewById(R.id.et_name)
        val ageEditText: EditText = view.findViewById(R.id.et_age)
        val genderRadioGroup: RadioGroup = view.findViewById(R.id.rg_sex)
        val activityLevelSpinner: Spinner = view.findViewById(R.id.sp_level)
        val submitButton: Button = view.findViewById(R.id.btn_submit)

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString()
            val selectedGenderId = genderRadioGroup.checkedRadioButtonId
            val gender = if (selectedGenderId != -1) {
                view.findViewById<RadioButton>(selectedGenderId).text.toString()
            } else {
                "Not specified"
            }
            val activityLevel = activityLevelSpinner.selectedItem.toString()

            val message = "Name: $name\nAge: $age\nGender: $gender\nActivity Level: $activityLevel"

            // Show the output in an AlertDialog
            AlertDialog.Builder(requireContext())
                .setTitle("Health Information")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show()
        }

        return view
    }
}


