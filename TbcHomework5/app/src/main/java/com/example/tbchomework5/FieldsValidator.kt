package com.example.tbchomework5

import android.widget.Toast
import com.example.tbchomework5.databinding.ActivityMainBinding

class FieldsValidator {
    private var fieldIsNotEmpty = true
    fun isUserNameEmpty(binding: ActivityMainBinding): Boolean {
        val userName = binding.etFullName.text.toString()
        if (userName.isEmpty()) {
            Toast.makeText(binding.root.context,
                binding.root.context.getString(R.string.username_field_is_empty), Toast.LENGTH_SHORT)
                .show()
            binding.etFullName.error = binding.root.context.getString(R.string.username_field_is_empty)
            fieldIsNotEmpty = false
        }
        return fieldIsNotEmpty
    }

    fun isEmailEmpty(binding: ActivityMainBinding): Boolean {
        val email = binding.etEmail.text.toString()
        if (email.isEmpty()) {
            Toast.makeText(binding.root.context,
                binding.root.context.getString(R.string.email_field_is_empty), Toast.LENGTH_SHORT).show()
            binding.etEmail.error = binding.root.context.getString(R.string.email_field_is_empty)
            fieldIsNotEmpty = false
        }
        return fieldIsNotEmpty
    }
}