package com.example.projet

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView



class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val questionText = findViewById<EditText>(R.id.head_question)
        val answertext = findViewById<EditText>(R.id.bottom_answer)
        val save_button = findViewById<ImageView>(R.id.imageView2)
        val cancel_button = findViewById<ImageView>(R.id.imageView3)

        cancel_button.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }

        save_button.setOnClickListener {
            val userQuestion = questionText.text.toString()
            val userAnswer = answertext.text.toString()

            val data = Intent() // create a new Intent, this is where we will put our data

            data.putExtra(
                "question_clef",
                userQuestion
            ) // puts one string into the Intent, with the key as 'string1'

            data.putExtra(
                "réponse_clef",
                userAnswer
            ) // puts another string into the Intent, with the key as 'string2

            setResult(RESULT_OK, data) // set result code and bundle data for response

            finish() // closes this activity and pass data to the original activity that launched this activity
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}