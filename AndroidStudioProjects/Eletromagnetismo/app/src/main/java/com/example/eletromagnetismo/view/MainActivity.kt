package com.example.eletromagnetismo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.eletromagnetismo.R
import com.example.eletromagnetismo.R.id
import com.example.eletromagnetismo.fragments.Home
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

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

        frameLayout = findViewById(R.id.content_main)
        bottomNavigation = findViewById(R.id.bottom_menu)

        contentInstance = frameLayout
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectListener)

        val fragment = Home.newInstance()
        addFragment(fragment)
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(id.content_main, fragment)
            .commit()
    }
}