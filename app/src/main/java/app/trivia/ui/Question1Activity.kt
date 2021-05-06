package app.trivia.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import app.trivia.R
import java.util.*

class Question1Activity : AppCompatActivity() {
    lateinit var etAnswer: EditText
    lateinit var tvQuestion: TextView
    lateinit var btnNext: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question1)
        Objects.requireNonNull(supportActionBar)?.setTitle(R.string.question_1)
        tvQuestion = findViewById<TextView>(R.id.tv_question) as TextView
        etAnswer = findViewById<EditText>(R.id.et_answer1) as EditText
        btnNext = findViewById<Button>(R.id.btn_next1) as Button


        //this button click listner will take input from this page and start the next page also pass the value from this page.

        btnNext.setOnClickListener{
            if (!TextUtils.isEmpty(etAnswer.text.toString())) {
                startActivity(
                    Intent(this@Question1Activity, Question2Activity::class.java)
                        .putExtra("ANSWER1", etAnswer.getText().toString())
                )
                finish()
            } else {
                Toast.makeText(
                    this@Question1Activity,
                    "Kindly answer this question!",
                    Toast.LENGTH_SHORT
                ).show()
                etAnswer.requestFocus()
            }
        }


    }
}