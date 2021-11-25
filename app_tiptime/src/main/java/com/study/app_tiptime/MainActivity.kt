package com.study.app_tiptime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.study.app_tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfServiceEditText.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null) {
            binding.tipResult.text = ""
            return
        }

        val selectedId = binding.tipOptions.checkedRadioButtonId
//        val tipPercentage = when (selectedId) {
//            R.id.option_twenty_percent -> 0.20
//            R.id.option_eighteen_percent -> 0.18
//            else -> 0.15
        var tipPercentage = 0.0
        if (selectedId == R.id.option_twenty_percent) {
            tipPercentage = 0.20
        } else if (selectedId == R.id.option_eighteen_percent) {
            tipPercentage = 0.18
        } else {
           tipPercentage = 0.15
        }

        var tip = tipPercentage * cost
        val roundUp = binding.roundUpSwitch.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)

    }


}