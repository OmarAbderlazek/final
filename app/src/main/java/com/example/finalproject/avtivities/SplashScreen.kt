package com.example.finalproject.avtivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.finalproject.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        Handler().postDelayed({ moveToLoginScreenActivity() }, 2000)
    }

    fun moveToLoginScreenActivity() {
        val moveToLoginScreenActivity = Intent(this, LoginScreen::class.java)
        startActivity(moveToLoginScreenActivity)
        finish()
    }
}