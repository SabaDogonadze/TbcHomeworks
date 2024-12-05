package com.example.tbchomework4

import android.util.Patterns
import android.widget.Toast
import com.example.tbchomework4.databinding.ActivityMainBinding

class EmailValidation {
    fun emailValidation(email:String,binding: ActivityMainBinding):Boolean{
        var isEmailCorrect = true
        if (!(Patterns.EMAIL_ADDRESS.matcher(email).matches())){
            Toast.makeText(binding.root.context, "Email - ის ველი არასწორია", Toast.LENGTH_SHORT).show()
            binding.etEmail.error = "შეიყვანეთ Email სწორად"
            isEmailCorrect = false
        }
        return isEmailCorrect
    }
}