package com.example.tbchomework4

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tbchomework4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp(){
        clickListeners()
    }

    private fun clickListeners(){
        binding.btnSave.setOnClickListener {

            if (isValidationsCorrect()){
                ManipulationOnInputs().disappearingFields(binding)
                ManipulationOnInputs().appearingTextFields(binding)
                ManipulationOnInputs().settingValuesToTextViews(binding)
            }else{
                Toast.makeText(this, "გთხოვთ შეასწოროთ შესატანი მნიშვნელობები", Toast.LENGTH_SHORT).show()
            }

        }
        binding.btnClear.setOnLongClickListener {
            ClearFields().clearFields(binding)
            true
        }

        binding.btnAgain.setOnClickListener {
            ManipulationOnInputs().appearingInputFields(binding)
            ManipulationOnInputs().backToStartingPosition(binding)
        }
    }


    private fun isValidationsCorrect():Boolean{
        val isViewEmpty = ViewsValidations().isViewEmpty(binding)
        val isUserNameValid = FieldsLengthsChecker().userNameLengthCheck(binding.etUserName.text.toString(),binding)
        val isAgeValid = AgeValidations().isAgePositiveNumber(binding)
        val isEmailValid =  EmailValidation().emailValidation(binding.etEmail.text.toString(), binding)
        return isViewEmpty && isUserNameValid && isAgeValid && isEmailValid
    }



    /*    private fun disappearingFields(){
        binding.etFirstName.visibility = View.GONE
        binding.etAge.visibility = View.GONE
        binding.etLastName.visibility = View.GONE
        binding.etEmail.visibility = View.GONE
        binding.etUserName.visibility = View.GONE
        binding.btnSave.visibility = View.GONE
        binding.btnClear.visibility = View.GONE
    }

    private fun appearingTextFields(){
        binding.tvFullName.visibility = View.VISIBLE
        binding.tvAge.visibility = View.VISIBLE
        binding.tvEmail.visibility = View.VISIBLE
        binding.tvUserName.visibility = View.VISIBLE
        binding.btnAgain.visibility = View.VISIBLE
    }

    private fun settingValuesToTextViews(){
        binding.tvAge.text= binding.etAge.text.toString()
        binding.tvFullName.text=
            (binding.etFirstName.text.toString() + binding.etLastName.text.toString())
                ?: "Full Name IS Empty"
        binding.tvEmail.text= binding.etEmail.text.toString()
        binding.tvUserName.text= binding.etUserName.text.toString()
    }
    private fun appearingInputFields(){
        binding.etAge.visibility = View.VISIBLE
        binding.etEmail.visibility = View.VISIBLE
        binding.etUserName.visibility = View.VISIBLE
        binding.etFirstName.visibility = View.VISIBLE
        binding.etLastName.visibility = View.VISIBLE
    }*/

   /* private fun backToStartingPosition(){
        binding.tvFullName.visibility = View.GONE
        binding.tvAge.visibility = View.GONE
        binding.tvEmail.visibility = View.GONE
        binding.tvUserName.visibility = View.GONE
        binding.btnAgain.visibility = View.GONE
        binding.btnSave.visibility = View.VISIBLE
        binding.btnClear.visibility = View.VISIBLE

        ClearFields().clearFields(binding)
    }*/
}

