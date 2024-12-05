package com.example.tbchomework4

import android.widget.Toast
import com.example.tbchomework4.databinding.ActivityMainBinding

class FieldsLengthsChecker {
    fun userNameLengthCheck(username:String,binding: ActivityMainBinding):Boolean{
        var userNameLengthIsCorrect = true
        if(username.length in 0..10){
            Toast.makeText(binding.root.context,"UserName სიმბოლოების რაოდენობა არ აღემატება 10-ს",Toast.LENGTH_SHORT).show()
            binding.etUserName.error = "UserName სიმბოლოების რაოდენობა არ აღემატება 10-ს"
            userNameLengthIsCorrect = false
            return userNameLengthIsCorrect
        }else return userNameLengthIsCorrect
    }
}