package app.trivia.helper

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class Helper{
    //this method will return the current data and time in required formate

    companion object {
        fun getCurrentDate(): String? {
            val dayNumberSuffix = getDayOfMonthSuffix(
                Calendar.getInstance()[Calendar.DAY_OF_MONTH]
            )
            val dateFormat: DateFormat =
                SimpleDateFormat(" d'$dayNumberSuffix' MMMM hh:mm aaa")
            return dateFormat.format(Calendar.getInstance().time)
        }

        fun getDayOfMonthSuffix(n: Int): String {
            return if (n >= 11 && n <= 13) {
                "th"
            } else when (n % 10) {
                1 -> "st"
                2 -> "nd"
                3 -> "rd"
                else -> "th"
            }
        }
    }
}