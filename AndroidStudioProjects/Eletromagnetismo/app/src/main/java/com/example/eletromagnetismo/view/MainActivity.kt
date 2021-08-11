package com.example.eletromagnetismo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.example.eletromagnetismo.R
import com.example.eletromagnetismo.R.id
import com.example.eletromagnetismo.fragments.Home
import com.example.eletromagnetismo.fragments.SetUserFragment
import com.example.eletromagnetismo.utils.sessionManagement.SessionManagment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var sessionVerifyer: SessionManagment
    private lateinit var bbBack:AppCompatButton
    lateinit var frameLayout: FrameLayout
    lateinit var bottomNavigation: BottomNavigationView
    private var contentInstance: FrameLayout? = null
    private var mOnNavigationItemSelectListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                id.home_navigation -> {
                    val fragment = Home.newInstance()
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        eventListener()
        firstFragment()

        frameLayout = findViewById(R.id.content_main)
        bottomNavigation = findViewById(R.id.bottom_menu)

        contentInstance = frameLayout
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectListener)

        val fragment = Home.newInstance()
        addFragment(fragment)
    }

    private fun eventListener() {
        bbBack.setOnClickListener {
            sessionVerifyer.finishSession()
            startActivity(Intent(this,FirstActivity::class.java))
        }
    }

    private fun initView() {
        bbBack = findViewById(id.bb_back)
        sessionVerifyer = SessionManagment(this)
    }

    private fun firstFragment() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.content_main, SetUserFragment.newInstance())
            commit()
        }
    }

    override fun onBackPressed() {

    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(id.content_main, fragment)
            .commit()
    }

}