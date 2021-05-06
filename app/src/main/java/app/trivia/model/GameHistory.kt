package app.trivia.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "gamehistory")
// this is class

class GameHistory{

    @PrimaryKey(autoGenerate = true)
    private var id = 0

    @ColumnInfo(name = "date")
    private var date: String? = null

    @ColumnInfo(name = "game")
    private var game: String? = null

    @ColumnInfo(name = "answer1")
    private var answer1: String? = null

    @ColumnInfo(name = "answer2")
    private var answer2: String? = null

    @ColumnInfo(name = "answer3")
    private var answer3: String? = null

    fun GameHistory() {}


    fun GameHistory(
        id: Int,
        date: String,
        game: String,
        answer1: String,
        answer2: String,
        answer3: String
    ) {
        this.id = id
        this.date = date
        this.game = game
        this.answer1 = answer1
        this.answer2 = answer2
        this.answer3 = answer3
    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getDate(): String? {
        return date
    }

    fun setDate(date: String) {
        this.date = date
    }

    fun getGame(): String? {
        return game
    }

    fun setGame(game: String) {
        this.game = game
    }


    fun getAnswer1(): String? {
        return answer1
    }

    fun setAnswer1(answer1: String) {
        this.answer1 = answer1
    }

    fun getAnswer2(): String? {
        return answer2
    }

    fun setAnswer2(answer2: String) {
        this.answer2 = answer2
    }

    fun getAnswer3(): String? {
        return answer3
    }

    fun setAnswer3(answer3: String) {
        this.answer3 = answer3
    }

}