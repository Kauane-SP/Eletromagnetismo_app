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

    private lateinit var contentForca: ConstraintLayout
    private lateinit var contentVetor: ConstraintLayout

    companion object {
        fun newInstance() = Home()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = activity as Context
        initView(view)
        eventListener()

    }

    private fun eventListener() {
        contentForca.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.content_main, Forca.newInstance())
                commit()
            }
        }

        contentVetor.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.content_main, Vetor.newInstance())
                commit()
            }
        }
    }

    private fun initView(view: View) {
        contentForca = view.findViewById(R.id.content_force)
        contentVetor = view.findViewById(R.id.content_vector)
    }


}