package app.trivia.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import app.trivia.model.GameHistory
import app.trivia.repository.MyRepository

//import app.trivia.repository.MyRepository

class SummaryViewModel : ViewModel() {
 /*   private var repositry: Repository
    private var myList: LiveData<List<GameHistory?>?>? = null
*/


    //this will insert the value in the datebase
    fun insertGame(context: Context, gameHistory: GameHistory) {
        MyRepository.insertGameHistory(context, gameHistory)
    }

    //this will get all the list of existing game history present in the database
    fun getList(context: Context): LiveData<List<GameHistory>> {
        return MyRepository.getAllList(context)
    }


}