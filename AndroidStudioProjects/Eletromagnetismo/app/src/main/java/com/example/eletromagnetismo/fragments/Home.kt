package com.example.eletromagnetismo.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.eletromagnetismo.R

class Home : Fragment() {

    companion object {
        fun newInstance() = Home()
    }

    private lateinit var contentForce: ConstraintLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = activity as Context

        contentForce = view.findViewById(R.id.content_force)
        contentForce.setOnClickListener {

        }
    }



}