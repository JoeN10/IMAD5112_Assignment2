package com.example.theflashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "South Africa is the world's smallest gold producer",
        "Nelson Mandela was the first black president in 1994",
        "In the 17th and 18th centuries there was much fighting between black tribes and Dutch settlers ",
        "South Africa has 1 capital citie",
        "Until the 1990s South Africa was governed by the apartheid gorvenment"
    )

    private val answer = booleanArrayOf(false, true, false, true, true)
    private fun displayQuestion(){
        questionTextView.text = questions[index]
        txtFeedback.text = ""
        falseButton.isEnabled = true
        trueButton.isEnabled = true
        nextButton.isEnabled = false
    }
    private var score = 0
    private var index = 0
    private lateinit var questionTextView: TextView
    private lateinit var txtFeedback: TextView
    private lateinit var nextButton: Button
    private lateinit var falseButton: Button
    private lateinit var trueButton: Button

    private fun answerChecker(userAnswer:Boolean){
        val correctAnswer = answer[index]
        if(userAnswer == correctAnswer){
            txtFeedback.text = "You are correct!"
            score++
        } else {
            txtFeedback.text = "You are Incorrect"
        }
        trueButton.isEnabled = false
        falseButton.isEnabled = false
        nextButton.isEnabled = true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)


        questionTextView = findViewById(R.id.questionTextView)
        txtFeedback = findViewById(R.id.txtFeedback)
        falseButton = findViewById(R.id.btnFalse)
        trueButton = findViewById(R.id.btnTrue)
        nextButton = findViewById(R.id.btnNext)

        displayQuestion()
        trueButton.setOnClickListener {
            answerChecker(true)
        }
        falseButton.setOnClickListener {
            answerChecker(false)
        }

        // The Quiz is finished, please go to score screen

        //  val intent = Intent(this, ScoreActivity::class.java)
        //  intent.putExtra("Score", score)
        //  intent.putExtra("Total_Questions", questions.size)
        //   startActivity(intent)
        //  finish()


        nextButton.setOnClickListener {
            index++
            if (index<questions.size){
                displayQuestion()
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()

            }

        }
    }




















    }
