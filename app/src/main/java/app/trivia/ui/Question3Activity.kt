package app.trivia.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import app.trivia.R
import java.util.*

class Question3Activity : AppCompatActivity() {
    lateinit var cbWhite: CheckBox
    lateinit  var cbYellow:CheckBox
    lateinit  var cbOrange:CheckBox
    lateinit  var cbGreen:CheckBox
    lateinit var tvQuestion: TextView
    lateinit var btnNext: Button
    private  var answer1:String? = null
    private  var answer2:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question3)
        Objects.requireNonNull(supportActionBar)?.setTitle(R.string.question_3)

        answer1 = intent.getStringExtra("ANSWER1")
        answer2 = intent.getStringExtra("ANSWER2")
        tvQuestion = findViewById<TextView>(R.id.tv_question2)
        cbWhite = findViewById<CheckBox>(R.id.cb_white)
        cbYellow = findViewById<CheckBox>(R.id.cb_yellow)
        cbOrange = findViewById<CheckBox>(R.id.cb_orange)
        cbGreen = findViewById<CheckBox>(R.id.cb_green)

        btnNext = findViewById<Button>(R.id.btn_next1)
        btnNext.setOnClickListener(View.OnClickListener { callnextIntent() })
    }

    //this method will take input from this page and make a call to next page called question3activity.
    //this will also validate the following checkbot for input, it will select more than one option seperated by comma.

    private fun callnextIntent() {
        var answer = ""
        if (!cbWhite.isChecked() && !cbYellow.isChecked() && !cbOrange.isChecked() && !cbGreen.isChecked()) {
            Toast.makeText(this, "Kindly select your answers!", Toast.LENGTH_SHORT).show()
        } else {
            if (cbWhite.isChecked()) {
                answer += getString(R.string.white)
            }
            if (cbYellow.isChecked()) {
                answer += if (TextUtils.isEmpty(answer)) {
                    getString(R.string.yellow)
                } else {
                    "," + getString(R.string.yellow)
                }
            }
            if (cbOrange.isChecked()) {
                answer += if (TextUtils.isEmpty(answer)) {
                    getString(R.string.orange)
                } else {
                    ", " + getString(R.string.orange)
                }
            }
            if (cbGreen.isChecked()) {
                answer += if (TextUtils.isEmpty(answer)) {
                    getString(R.string.green)
                } else {
                    ", " + getString(R.string.green)
                }
            }

            Log.d("MYVALUE", "callnextIntent: answer $answer")
            startActivity(
                Intent(this@Question3Activity, SummaryActivity::class.java)
                    .putExtra("ANSWER1", answer1)
                    .putExtra("ANSWER2", answer2)
                    .putExtra("ANSWER3", answer)
            )
            finish()
        }
    }
}