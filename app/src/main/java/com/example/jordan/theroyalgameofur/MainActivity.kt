package com.example.jordan.theroyalgameofur

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageButton
import java.util.*

class MainActivity : AppCompatActivity() {
    val PLayer1 : Int = 0
    val Player2 : Int = 0
    var random = Random()
    var timer = Timer()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnStart = findViewById<ImageButton>(R.id.imgBtnStart)

        btnStart.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, GameScreen::class.java)
            //val intent = Main2Activity(this, user)
            startActivity(intent)
        })

    }

    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }


}
