package com.example.tbchomework5

import android.media.audiofx.BassBoost
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tbchomework5.databinding.ActivityMainBinding
import java.time.temporal.IsoFields

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var users: MutableList<UserData> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp() {
        listeners()
    }

    private fun listeners() {
        binding.btnAddUser.setOnClickListener {
            if (isFieldValidatorCorrect() && isEmailCorrect()) {
                addUsers()
                currentUsersCounter()
            } else {
                Toast.makeText(this, getString(R.string.check_input_fields), Toast.LENGTH_SHORT)
                    .show()
            }
        }
        binding.btnGetUserInfo.setOnClickListener {
            if (binding.etEnterEmail.text.toString().isNotEmpty()) {
                getUserInfo(binding.etEnterEmail.text.toString())
            } else {
                Toast.makeText(this, getString(R.string.input_value_is_empty), Toast.LENGTH_SHORT)
                    .show()
                binding.etEnterEmail.error = getString(R.string.input_value_is_empty)
            }
        }
    }

    private fun currentUsersCounter() {
        binding.tvActiveUsers.text = users.size.toString()
    }

    private fun addUsers() {
        val userFullName = binding.etFullName.text.toString()
        val email = binding.etEmail.text.toString()
        val doesUserAlreadyExists = users.any { it.email == email }
        if (doesUserAlreadyExists) {
            Toast.makeText(this, getString(R.string.user_already_exists), Toast.LENGTH_SHORT).show()
            /*    binding.tvActiveUsersTitle.error = "User Already Exists"*/
        } else {
            val user = UserData(userFullName, email)
            users.add(user)
        }
    }

    private fun isFieldValidatorCorrect(): Boolean {
        val isFullNameEmpty = FieldsValidator().isUserNameEmpty(binding)
        val isEmailEmpty = FieldsValidator().isEmailEmpty(binding)

        return isFullNameEmpty && isEmailEmpty
    }

    private fun isEmailCorrect(): Boolean {
        val isEmailCorrect =
            EmailValidator().emailValidation(binding.etEmail.text.toString(), binding)
        return isEmailCorrect
    }

    private fun getUserInfo(email: String) {
        val userInfo = users.any { it.email == email }
        if (userInfo) {
            val user = users.find { it.email == email }
            binding.tvUserFullName.text = user?.fullName
        } else {
            Toast.makeText(this, getString(R.string.user_not_found), Toast.LENGTH_SHORT).show()
        }
    }

}