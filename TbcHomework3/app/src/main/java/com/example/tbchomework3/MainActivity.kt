package com.example.tbchomework3

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tbchomework3.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val currentLanguage = getSharedPreferences("LanguagePrefs", MODE_PRIVATE)  // app saves and retrieves user preferences for the language
            .getString("language","ka" ) ?: "ka"                                         // key , is "language" and default value is "ka" // ?: "ka" is value if null happens, unlikely to happen but ..
        setLocale(currentLanguage)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateToggleState(currentLanguage)
        setUp()
    }

    private fun setUp() {
        clickListeners()
    }

    private fun clickListeners() {
        binding.tglBtn.setOnCheckedChangeListener { _, isChecked ->
            val language = if (isChecked) "en" else "ka"

            getSharedPreferences("LanguagePrefs", MODE_PRIVATE)
                .edit()
                .putString("language", language)
                .apply()

            setLocale(language)
            recreate()
        }

        binding.btnApply.setOnClickListener {
            val inputNumber = binding.etInputNumber.text.toString()
            if (inputNumber.isNotEmpty() && inputNumber[0] != '0') {
                try {
                    val number = inputNumber.toInt()
                    if (number in 1..<1000) {
                        if (getSharedPreferences("LanguagePrefs", MODE_PRIVATE)
                                .getString("language","ka" ) == "ka"
                        ) {
                            binding.tvNumberOutput.text = convertNumbersToGeorgianWords(number)
                        } else {
                            binding.tvNumberOutput.text = convertNumberToEnglish(number)
                        }
                    } else {
                        Toast.makeText(
                            this,
                            getString(R.string.input_error_message),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(
                        this,
                        getString(R.string.input_error_message),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(this, getString(R.string.input_error_message), Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun setLocale(languageCode: String) {   // Locale is responsible for app language which is changed dynamically at run time
        val locale = Locale(languageCode)    // creating locale object,  Locale IS A Class
        Locale.setDefault(locale)   // updating default Locale with newly created locale

        val config = Configuration(resources.configuration)  // creting a copy of a Configuration object, which holds various settings about app display ( scale, orientation,screen size, and locale)
        config.setLocale(locale)  // updating a configurations locale with a new locale which was created above
                                    // without this app won't load resources in the desired language

        resources.updateConfiguration(config, resources.displayMetrics)  // without this line UI would not reflect language change immediately
    }

    private fun updateToggleState(language: String) {
        binding.tglBtn.isChecked = language == "en"
    }

}


private fun convertNumbersToGeorgianWords(inputNumber: Int): String {
    var number = inputNumber

    val numberLastDigit = number % 10
    val numberSecondDigit = (number / 10) % 10
    val numberFirstDigit = number / 100

    if (numberLastDigit == 0 && numberSecondDigit == 0) {
        return GeorgianWordsList.hundredNumbers[numberFirstDigit] + "ი"
    }
    if (number in 100..<1000) {
        return if (numberLastDigit == 0) {
            GeorgianWordsList.hundredNumbers[numberFirstDigit] + GeorgianWordsList.decimalNumbers[numberSecondDigit] + "ი"
        } else if (numberSecondDigit % 2 == 0) {
            GeorgianWordsList.hundredNumbers[numberFirstDigit] + GeorgianWordsList.decimalNumbersExceptions[numberSecondDigit] + GeorgianWordsList.numbers[numberLastDigit]
        } else if (numberSecondDigit == 1) {
            GeorgianWordsList.hundredNumbers[numberFirstDigit] + GeorgianWordsList.numbersElevenToTwenty[numberLastDigit]
        } else {
            GeorgianWordsList.hundredNumbers[numberFirstDigit] + GeorgianWordsList.decimalNumbersExceptions[numberSecondDigit] + GeorgianWordsList.numbersElevenToTwenty[numberLastDigit]
        }
    }
    if (number in 20..<100) {
        val numberSecondDigitInTwoDigitNumber = number % 10
        val numberFirstDigitInTwoDigitNumber = number / 10
        if (numberSecondDigitInTwoDigitNumber == 0) {
            return GeorgianWordsList.decimalNumbers[numberFirstDigitInTwoDigitNumber]
        } else if (numberFirstDigitInTwoDigitNumber % 2 == 0) {
            return GeorgianWordsList.decimalNumbersExceptions[numberFirstDigitInTwoDigitNumber] + GeorgianWordsList.numbers[numberSecondDigitInTwoDigitNumber]
        } else {
            return GeorgianWordsList.decimalNumbersExceptions[numberFirstDigitInTwoDigitNumber] + GeorgianWordsList.numbersElevenToTwenty[numberSecondDigitInTwoDigitNumber]

        }
    }

    return if (number in 11..19) {
        GeorgianWordsList.numbersElevenToTwenty[numberLastDigit]
    } else {
        GeorgianWordsList.numbers[number]
    }
}

fun convertNumberToEnglish(inputNumber: Int): String {
    var number = inputNumber

    val numberLastDigit = number % 10
    val numberSecondDigit = (number / 10) % 10
    val numberFirstDigit = number / 100

    val numberSecondDigitInTwoDigitNumber = number % 10
    val numberFirstDigitInTwoDigitNumber = number / 10

    if (numberLastDigit == 0 && numberSecondDigit == 0) {
        return EnglishWordsList.number[numberFirstDigit] + EnglishWordsList.hundred
    }
    if (number in 100..999) {
        return if (numberLastDigit == 0 && numberSecondDigit > 1) {
            EnglishWordsList.number[numberFirstDigit] + EnglishWordsList.hundred + EnglishWordsList.tens[numberSecondDigit]
        } else if (numberSecondDigit == 1) {
            EnglishWordsList.number[numberFirstDigit] + EnglishWordsList.hundred + EnglishWordsList.numberTenToTwenty[numberLastDigit]
        } else {
            EnglishWordsList.number[numberFirstDigit] + EnglishWordsList.hundred + EnglishWordsList.tens[numberSecondDigit] + EnglishWordsList.number[numberLastDigit]
        }
    }
    if (number in 20..99) {
        return if (numberSecondDigitInTwoDigitNumber == 0) {
            EnglishWordsList.tens[numberFirstDigitInTwoDigitNumber]
        } else {
            EnglishWordsList.tens[numberFirstDigitInTwoDigitNumber] + EnglishWordsList.number[numberSecondDigitInTwoDigitNumber]
        }
    }
    if (number in 10..19) {
        return EnglishWordsList.numberTenToTwenty[numberSecondDigitInTwoDigitNumber]
    } else
        return EnglishWordsList.number[number]
}

