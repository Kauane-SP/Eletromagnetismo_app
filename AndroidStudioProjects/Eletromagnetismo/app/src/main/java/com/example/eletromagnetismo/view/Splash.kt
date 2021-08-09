package com.example.eletromagnetismo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import com.example.eletromagnetismo.R

class Splash : AppCompatActivity() {

    lateinit var handler: Handler
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler = Handler()
        handler.postDelayed({
            progressBar = findViewById(R.id.pb_loading_splash)
            progressBar.progress = 70
            progressBar.max = 100
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}