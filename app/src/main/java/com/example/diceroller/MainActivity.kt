package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

//This activity allows the user to roll a dice and view the result onscreen
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Find the button in the UI and make it roll dice whenever it is clicked
        val rollButton: Button = findViewById(R.id.rollDiceButton)
        rollButton.setOnClickListener { rollDice() }

        //roll dice when the app starts
        rollDice()
    }

    private fun rollDice() {
        // Get the Imageview to be updated
        val diceImage: ImageView = findViewById(R.id.diceImageView)
        val diceImage2: ImageView = findViewById(R.id.diceImageView2)

        val diceRoll = Dice(6).roll()
        val diceRoll2: Int = Dice(6).roll()

        //Decide which image to display based on value of dice rolled
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Update the image view with appropriate image and set content description
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()
    }
}

// This class creates a template for making dice objects
class Dice(private val numSides: Int) {

    fun roll(): Int {
        //Pick a random number out of the number of sides specified by the user
        return (1..numSides).random()
    }
}