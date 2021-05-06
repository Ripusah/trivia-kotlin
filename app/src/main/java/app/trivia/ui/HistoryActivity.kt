package app.trivia.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.trivia.R
import app.trivia.adapter.GameHistoryAdapter
import app.trivia.model.GameHistory
import app.trivia.viewmodel.SummaryViewModel
import java.util.*

class HistoryActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit private var adapter: GameHistoryAdapter
    lateinit private var model: SummaryViewModel
    private var mList: List<GameHistory> = ArrayList<GameHistory>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        Objects.requireNonNull(supportActionBar)?.setTitle(R.string.game_hitory)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        model = ViewModelProvider(this).get(SummaryViewModel::class.java)
        recyclerView = findViewById<RecyclerView>(R.id.recycleview)
        setRecycleView()

        //this will update the value of list using observe
        model.getList(this)?.observe(this, Observer {
            adapter.setValues(it)
        })
    }

    //this will help for navigation
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        finish()
    }
    //initialise the recycle view and adapeter
    private fun setRecycleView() {
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        adapter = GameHistoryAdapter(this, mList)
        recyclerView.setAdapter(adapter)
    }
}