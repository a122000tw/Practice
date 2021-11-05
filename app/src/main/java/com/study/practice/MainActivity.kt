package com.study.practice

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this

        val rollButton: Button = findViewById(R.id.btn)
        rollButton.setOnClickListener {
//            Toast.makeText(context, "Dice Roll!", Toast.LENGTH_SHORT).show()
            rollDice()
        }
    }

    private fun rollDice() {
        val dice = 1..6
        val rollDice = dice.random()
        val imageDice: ImageView = findViewById(R.id.image_dice)
//        when (rollDice) {
//            1 -> imageDice.setImageResource(R.drawable.dice_1)
//            2 -> imageDice.setImageResource(R.drawable.dice_2)
//            3 -> imageDice.setImageResource(R.drawable.dice_3)
//            4 -> imageDice.setImageResource(R.drawable.dice_4)
//            5 -> imageDice.setImageResource(R.drawable.dice_5)
//            6 -> imageDice.setImageResource(R.drawable.dice_6)
//        }
        val drawableResoure = when (rollDice) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        imageDice.setImageResource(drawableResoure)
        imageDice.contentDescription = rollDice.toString()

    }


}