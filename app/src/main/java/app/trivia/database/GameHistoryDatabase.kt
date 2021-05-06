package app.trivia.database

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import app.trivia.interfaces.GameHistoryDao
import app.trivia.model.GameHistory

//this is the database which will store the data and fetch the data based on the request.
@Database(entities = [GameHistory::class], version = 1)
abstract class GameHistoryDatabase: RoomDatabase() {
    abstract fun gameHistoryDao(): GameHistoryDao

    companion object {
        @Volatile private var instance: GameHistoryDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            GameHistoryDatabase::class.java, "gamehistory_database1")
            .build()
    }

}