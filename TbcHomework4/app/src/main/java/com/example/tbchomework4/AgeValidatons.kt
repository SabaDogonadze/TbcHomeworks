package com.example.tbchomework4

import android.widget.Toast
import com.example.tbchomework4.databinding.ActivityMainBinding

class AgeValidations {
    fun isAgePositiveNumber(binding: ActivityMainBinding):Boolean{
        var isAgePositiveNumber = true
        try {
            val age = binding.etAge.text.toString().toInt()
            if(age<0 || age > 130){
                Toast.makeText(binding.root.context, "შეიყვანეთ ასაკი სწორად ", Toast.LENGTH_SHORT).show()
                binding.etAge.error = "შშეიყვანეთ ასაკი სწორად"
                isAgePositiveNumber = false
                return isAgePositiveNumber
            }
        }catch (e:NumberFormatException){
            Toast.makeText(binding.root.context, "შეიყვანეთ მთელი რიცხვი ", Toast.LENGTH_SHORT).show()
            binding.etAge.error = "შეიყვანეთ მთელი რიცხვი"
        }
        return isAgePositiveNumber
    }
}