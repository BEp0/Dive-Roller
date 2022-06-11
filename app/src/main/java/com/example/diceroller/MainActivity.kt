package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    /**
     * This activity allows the user to roll a dice and view the result
     * on the screen.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener() { rollDice() } // roll the dice when click

        // Do a dice roll when the app starts
        rollDice()
    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        val dice = Dice(6) // Create new dice object with 6 sides
        // Roll the dice twice
        val diceRoll1 = dice.roll()
        val diceRoll2 = dice.roll()

        // Find the ImageViews in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2) // Second dice

        // Determinate which drawtable resource ID to use based on the dice roll
        val drawTableResourceDiceOne = when(diceRoll1){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Determinate which drawtable resource ID to use based on the dice roll
        val drawTableResourceDiceTwo = when(diceRoll2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // update the images Resources with id
        diceImage.setImageResource(drawTableResourceDiceOne)
        diceImage2.setImageResource(drawTableResourceDiceTwo)
        // Update the content description
        diceImage.contentDescription = diceRoll1.toString()
        diceImage2.contentDescription = diceRoll2.toString()

        //resultTextView.text = "${dice.roll()}"
        //resultImageView.text = dice.roll().toString()
        //resultTextView2.text = dice.roll().toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}