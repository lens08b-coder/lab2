package com.example.projet

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView
import android.content.Intent
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts





class MainActivity : AppCompatActivity() {
    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val data: Intent? = result.data
        if (data != null) { // Check that we have data returned
            val question = intent.getStringExtra("question_clef")
            val answer = intent.getStringExtra("réponse_clef")

            // Log the value of the strings for easier debugging
            Log.i("MainActivity", "string1: $question")
            Log.i("MainActivity", "string2: $answer")
            findViewById<TextView>(R.id.head).text = question
            findViewById<TextView>(R.id.answer).text = answer

        } else {
            Log.i("MainActivity", "Returned null data from MainActivity2")
        }
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val questionText = findViewById<TextView>(R.id.head)
        val answertext = findViewById<TextView>(R.id.answer)
        val icon = findViewById<ImageView>(R.id.jeez)

            icon.setOnClickListener {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }

        questionText.setOnClickListener {
            questionText.visibility = View.INVISIBLE
            answertext.visibility = View.VISIBLE
        }
        answertext.setOnClickListener {
            questionText.visibility = View.VISIBLE
            answertext.visibility = View.INVISIBLE
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}