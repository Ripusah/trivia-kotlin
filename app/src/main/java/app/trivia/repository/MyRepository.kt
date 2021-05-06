package app.trivia.repository

import android.app.Application
import android.content.Context
import android.os.AsyncTask
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import app.trivia.database.GameHistoryDatabase
import app.trivia.interfaces.GameHistoryDao
import app.trivia.model.GameHistory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MyRepository{
    //this construct will initialise/create object of repository and Dao

    companion object {

        var database: GameHistoryDatabase? = null

        var myList: LiveData<GameHistory>? = null

        fun initializeDB(context: Context) : GameHistoryDatabase {
            return GameHistoryDatabase.invoke(context)
        }

        fun insertGameHistory(context: Context, gameHistory: GameHistory) {

            database = initializeDB(context)
            Log.d("TAGTAG", "insertGameHistory: called ")

            InsertTransactionAsyncTask(context , database!!.gameHistoryDao()).execute(gameHistory)


        }

        fun getAllList(context: Context) : LiveData<List<GameHistory>> {

            database = initializeDB(context)

            return database!!.gameHistoryDao().getAllHistory()

        }

        // this method will take input from viewmodel and pass it to asynctask to insert the data in the database

        internal class InsertTransactionAsyncTask(
            application: Context,
            gameHistoryDao: GameHistoryDao
        ) :
            AsyncTask<GameHistory?, Void?, Void?>() {
            var gameHistoryDao: GameHistoryDao
            var application: Context
            var id: Long = 0
            protected override fun doInBackground(vararg transactions: GameHistory?): Void? {
                id = gameHistoryDao.insertGame(transactions[0])
                Log.d("MYTAG", "doInBackground: index $id")
                val handler = Handler(application.mainLooper)

                //this will check the success of the insertion of the data in the table.
                handler.post {
                    if (id != -1L) {
                        Toast.makeText(
                            application,
                            "Transaction Inserted successfully ",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(application, "Error! ", Toast.LENGTH_LONG).show()
                    }
                }
                return null
            }

            init {
                this.gameHistoryDao = gameHistoryDao
                this.application = application
            }
        }

    }
}