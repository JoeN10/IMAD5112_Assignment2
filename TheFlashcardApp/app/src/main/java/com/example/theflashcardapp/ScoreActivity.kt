package com.example.theflashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        val txtScore = findViewById<TextView>(R.id.txtScore)
        val reviewButton = findViewById<Button>(R.id.btnReview)
        val exitButton = findViewById<Button>(R.id.btnExit)
        val feedback = findViewById<TextView>(R.id.txtFeedback)
        val score = intent.getIntExtra("score",0)


        txtScore.text="Your Score: $score out of 5"



        reviewButton.setOnClickListener {
            // Please review functionality
            when (score){
                in 4..5-> feedback.text = "Excellent work!"
                in  2..3-> feedback.text = "Good job!"

                else -> feedback.text = "Keep practicing!"
            }


        }

        exitButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            //Please close all activities and exit app
        }














































        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}