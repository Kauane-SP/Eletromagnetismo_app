package com.example.eletromagnetismo.view

import android.content.Intent
import android.os.Bundle
import com.example.eletromagnetismo.R
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide

class Splash : IntroActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_splash)

        isButtonBackVisible = false
        isButtonNextVisible = false

        addSlide(
            SimpleSlide.Builder()
                .title("Wellcome")
                .image(R.drawable.books_purple)
                .description("Olá seja bem vindo a calculadora de eletromagnetismo , um jeito fácil de estudar e aprender mais !")
                .background(R.color.white)
                .backgroundDark(R.color.white)
                .scrollable(false)
                .build()
        )

        addSlide(
            SimpleSlide.Builder()
                .title("Vamos lá")
                .image(R.drawable.calculator_verde)
                .description("Para usar é fácil, basta escolher qual tipo de equação você deseja realizar e iserir seus  respectivos valore . Bons estudos ! ")
                .background(R.color.white)
                .backgroundDark(R.color.white)
                .scrollable(false)
                .build()
        )
    }

    override fun onDestroy() {
        super.onDestroy()

        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}