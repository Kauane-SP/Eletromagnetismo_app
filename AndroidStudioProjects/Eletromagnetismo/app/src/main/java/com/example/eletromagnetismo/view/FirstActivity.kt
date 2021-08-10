package com.example.eletromagnetismo.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eletromagnetismo.R
import com.example.eletromagnetismo.fragments.SetUserFragment
import com.example.eletromagnetismo.utils.sessionManagement.SessionManagment

class FirstActivity : AppCompatActivity() {

    private lateinit var sessionVerifyer: SessionManagment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        sessionVerifyer = SessionManagment(this)
        verifySecssion(this)
    }

    private fun verifySecssion(context: Context) {
        if (!sessionVerifyer.getInfoSession()){
            startActivity(Intent(context, Slids::class.java))
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.content_init, SetUserFragment.newInstance())
                commit()
            }
        }else{
            startActivity(Intent(context, MainActivity::class.java))
        }
    }
}