package app.trivia.interfaces

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import app.trivia.model.GameHistory
@Dao
interface GameHistoryDao {
    //this interface which will be called dao for performing operation of database

    @Insert
    fun insertGame(gameHistory: GameHistory?): Long

    @Query("SELECT * FROM gamehistory")
    fun getAllHistory(): LiveData<List<GameHistory>>
}