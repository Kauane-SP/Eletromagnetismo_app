package com.example.eletromagnetismo.view

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.eletromagnetismo.R
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide

class Slids : IntroActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isButtonBackVisible = false
        isButtonNextVisible = false
//        navController = Navigation.findNavController(view)

        addSlide(
            SimpleSlide.Builder()
                .title("Wellcome")
                .image(R.drawable.ic_book)
                .description("Olá seja bem vindo a calculadora de eletromagnetismo , um jeito fácil de estudar e aprender mais !")
                .background(R.color.white)
                .backgroundDark(R.color.white)
                .scrollable(false)
                .build()
        )

        addSlide(
            SimpleSlide.Builder()
                .title("Vamos lá")
                .image(R.drawable.ic_calculator)
                .description("Para usar é fácil, basta escolher qual tipo de equação você deseja realizar e iserir seus  respectivos valore . Bons estudos ! ")
                .background(R.color.white)
                .backgroundDark(R.color.white)
                .scrollable(false)
                .build()
        )
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}