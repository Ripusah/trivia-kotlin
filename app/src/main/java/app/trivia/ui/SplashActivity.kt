package app.trivia.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import app.trivia.R
import app.trivia.helper.Helper

class SplashActivity : AppCompatActivity() {
    lateinit var ivSplash: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        ivSplash = findViewById<ImageView>(R.id.iv_splash)

        Log.d("MYDATES", "onCreate: dates " + Helper.getCurrentDate())
        val aniSlide = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.image_zoom
        )
        ivSplash.startAnimation(aniSlide)
        //this will start splashfile for 2 sec and then move to next page for question .

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, Question1Activity::class.java))
            finish()
        }, 2000)
    }
}