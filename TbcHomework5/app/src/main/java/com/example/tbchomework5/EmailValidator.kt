package com.example.tbchomework5

import android.util.Patterns
import android.widget.Toast
import com.example.tbchomework5.databinding.ActivityMainBinding

class EmailValidator {
    fun emailValidation(email:String,binding: ActivityMainBinding):Boolean{
        if (!(Patterns.EMAIL_ADDRESS.matcher(email).matches())){
            Toast.makeText(binding.root.context, binding.root.context.getString(R.string.email_input_is_wrong), Toast.LENGTH_SHORT).show()
            binding.etEmail.error = binding.root.context.getString(R.string.email_input_is_wrong)
           return false
        }
        return true
    }
}