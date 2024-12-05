package com.example.tbchomework4

import com.example.tbchomework4.databinding.ActivityMainBinding

class ClearFields {
    fun clearFields(binding: ActivityMainBinding){
        binding.etUserName.text?.clear()
        binding.etEmail.text?.clear()
        binding.etAge.text?.clear()
        binding.etFirstName.text?.clear()
        binding.etLastName.text?.clear()
    }
}