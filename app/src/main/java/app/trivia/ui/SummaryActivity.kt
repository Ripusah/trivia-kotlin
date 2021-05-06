package app.trivia.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.trivia.R
import app.trivia.helper.Helper
import app.trivia.model.GameHistory
import app.trivia.viewmodel.SummaryViewModel
import java.util.*

class SummaryActivity : AppCompatActivity() {
    private  var answer1:String? = null
    private  var answer2:String? = null
    private  var answer3:String? = null
    private  var date:String? = ""
    lateinit var tvAnswer1: TextView
    lateinit  var tvAnswer2:TextView
    lateinit  var tvAnswer3:TextView
    lateinit var btnFinish: Button
    lateinit var model: SummaryViewModel
    var count = 0
    private var insert = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        Objects.requireNonNull(supportActionBar)?.setTitle(R.string.summary)
        btnFinish = findViewById<Button>(R.id.btn_next1)
        model = ViewModelProvider(this).get(SummaryViewModel::class.java)
        answer1 = intent.getStringExtra("ANSWER1")
        answer2 = intent.getStringExtra("ANSWER2")
        answer3 = intent.getStringExtra("ANSWER3")
        tvAnswer1 = findViewById<TextView>(R.id.tv_answer1)
        tvAnswer2 = findViewById<TextView>(R.id.tv_answer2)
        tvAnswer3 = findViewById<TextView>(R.id.tv_answer3)
        tvAnswer1.setText(getString(R.string.hello, answer1))
        tvAnswer2.setText(answer2)
        tvAnswer3.setText(answer3)

        //this will get the total count of the game and update the count value

        model.getList(this)?.observe(this, Observer {
            if (it != null) {
                count = it.size + 1
                Log.d("MYTAG", "onCreate: "+count)
            }

        })
        //this is to start again the game from start, if the data is not save this will save the data first and start the game.

        btnFinish.setOnClickListener(View.OnClickListener {
            setValue()
            finish()
            startActivity(Intent(this@SummaryActivity, Question1Activity::class.java))
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_history, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //this will show the all the history of game with is stored in the databse, if the data of the current game is not saved it will save the data first
        // move to next page
        if (item.itemId == R.id.op_history) {
            setValue()
            startActivity(Intent(this@SummaryActivity, HistoryActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }


    //this method to save the data in database using viewmodel and roomdata base
    private fun setValue() {
        if (insert) {
            val gameHistory = GameHistory()
            //int count=model.getCount();
            Helper.getCurrentDate()?.let { gameHistory.setDate(it) }
            gameHistory.setGame("Game $count")
            answer1?.let { gameHistory.setAnswer1(it) }
            answer2?.let { gameHistory.setAnswer2(it) }
            answer3?.let { gameHistory.setAnswer3(it) }
            model.insertGame(this,gameHistory)
            insert = false
        }
    }
}