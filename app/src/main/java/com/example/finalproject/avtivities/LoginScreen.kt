package com.example.finalproject.avtivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.finalproject.R
import kotlinx.android.synthetic.main.activity_login_screen.*
import java.util.regex.Pattern

class LoginScreen : AppCompatActivity() {
    val BASE_URL = "https://academy-training.appssquare.com/api"

    val PASSWORD_PATTERN =
        Pattern.compile("(?=.*[0-9])" + "(?=.*[a-zA-Z])" + ".{8,25}" + "$")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        supportActionBar?.hide()

    }

    fun moveToRecyclerViewScreen(view: View) {
        val phone = phone_view.text
        val pass = password_view.text
        val moveToRecyclerViewScreen = Intent(this, RecyclerViewScreen::class.java)
        moveToRecyclerViewScreen.putExtra("phone_info", phone)
        moveToRecyclerViewScreen.putExtra("pass_info", pass)
        startActivity(moveToRecyclerViewScreen)
    }

    fun checkValidate(view: View) {
        if (phone_view.text!!.isEmpty() && password_view.text!!.isNotEmpty()) {
            phone_view.error = "This field cannot be empty"
        }
        else if (phone_view.text!!.isNotEmpty() && password_view.text!!.isEmpty()) {
            password_view.error = "this field cannot be empty"
        }
        else if (phone_view.text!!.isEmpty() && password_view.text!!.isEmpty()) {
            phone_view.error = "This field cannot be empty"
            password_view.error = "This field cannot be empty"
        }
        else if (!PASSWORD_PATTERN.matcher(password_view.text).matches()) {
            password_view.error = "password must be 8:25 characters\nand contains at least 1 number\nand contains at least 1 letter"
        }
        else {
            moveToRecyclerViewScreen(view)
        }
    }
}