package com.example.tbchomework6

import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tbchomework6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp(){
        setViewParameters()
        applyGradientToText()
    }

    private fun setViewParameters(){
        binding.apply {
           tvMountainTitle.text = getString(R.string.mountain_title)
            tvPriceTitle.text = getString(R.string.price)
            tvLocation.text = getString(R.string.location)
            tvCurrency.text = getString(R.string.dollar_sign)
            tvPrice.text = getString(R.string.tour_price)
            tvOverview.text = getString(R.string.overview)
            tvDetails.text = getString(R.string.details)
            tvTime.text = getString(R.string.time)
            tvWeather.text = getString(R.string.temperature)
            tvRating.text = getString(R.string.rating)
            tvDescription.text = getString(R.string.description)
            btnBookNow.text = getString(R.string.book_now)
        }
    }

    private fun applyGradientToText() {
        val tvDescription = binding.tvDescription
        val textShader = LinearGradient(
            0f, 0f, 0f, tvDescription.lineHeight * 5f,
            intArrayOf(
                0xFF000000.toInt(),
                0x80000000.toInt(),
                0x00000000
            ),
            floatArrayOf(0f, 0.7f, 1f),
            Shader.TileMode.CLAMP
        )

        tvDescription.paint.shader = textShader
        tvDescription.invalidate()
    }
}