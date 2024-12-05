package com.example.tbchomework4

import android.view.View
import com.example.tbchomework4.databinding.ActivityMainBinding

class ManipulationOnInputs() {
     fun disappearingFields(binding: ActivityMainBinding){
        binding.etFirstName.visibility = View.GONE
        binding.etAge.visibility = View.GONE
        binding.etLastName.visibility = View.GONE
        binding.etEmail.visibility = View.GONE
        binding.etUserName.visibility = View.GONE
        binding.btnSave.visibility = View.GONE
        binding.btnClear.visibility = View.GONE
    }

     fun appearingTextFields(binding: ActivityMainBinding){
        binding.tvFullName.visibility = View.VISIBLE
        binding.tvAge.visibility = View.VISIBLE
        binding.tvEmail.visibility = View.VISIBLE
        binding.tvUserName.visibility = View.VISIBLE
        binding.btnAgain.visibility = View.VISIBLE
    }
     fun appearingInputFields(binding: ActivityMainBinding){
        binding.etAge.visibility = View.VISIBLE
        binding.etEmail.visibility = View.VISIBLE
        binding.etUserName.visibility = View.VISIBLE
        binding.etFirstName.visibility = View.VISIBLE
        binding.etLastName.visibility = View.VISIBLE
    }
     fun backToStartingPosition(binding: ActivityMainBinding){
        binding.tvFullName.visibility = View.GONE
        binding.tvAge.visibility = View.GONE
        binding.tvEmail.visibility = View.GONE
        binding.tvUserName.visibility = View.GONE
        binding.btnAgain.visibility = View.GONE
        binding.btnSave.visibility = View.VISIBLE
        binding.btnClear.visibility = View.VISIBLE

        ClearFields().clearFields(binding)
    }

     fun settingValuesToTextViews(binding: ActivityMainBinding){
        binding.tvAge.text= binding.etAge.text.toString()
        binding.tvFullName.text=
            (binding.etFirstName.text.toString() + binding.etLastName.text.toString())
                ?: "Full Name IS Empty"
        binding.tvEmail.text= binding.etEmail.text.toString()
        binding.tvUserName.text= binding.etUserName.text.toString()
    }
}