package app.trivia.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import app.trivia.R
import java.util.*

class Question2Activity : AppCompatActivity() {
    lateinit var rgOptions: RadioGroup
    lateinit var radioButton: RadioButton
    lateinit var tvQuestion: TextView
    lateinit var btnNext: Button
    private  var answer1:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question2)
        Objects.requireNonNull(supportActionBar)?.setTitle(R.string.question_2)
        tvQuestion = findViewById<TextView>(R.id.tv_question1)
        rgOptions = findViewById<RadioGroup>(R.id.rg_options)
        answer1 = intent.getStringExtra("ANSWER1")

        btnNext = findViewById<Button>(R.id.btn_next1)
        btnNext.setOnClickListener(View.OnClickListener {
            //calling the method callintent
            callnextIntent() })


    }

    //this method will take input from this page and make a call to next page called question3activity.
    //this will also validate the following radio button for input
    private fun callnextIntent() {
        val selectedId: Int = rgOptions.getCheckedRadioButtonId()
        radioButton = findViewById<View>(selectedId) as RadioButton
        if (rgOptions.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this@Question2Activity, "Kindly select any of them!", Toast.LENGTH_SHORT)
                .show()
        } else {
            startActivity(
                Intent(this@Question2Activity, Question3Activity::class.java)
                    .putExtra("ANSWER1", answer1)
                    .putExtra("ANSWER2", radioButton.getText())
            )
            finish()
        }
    }


}