package com.example.eletromagnetismo.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.eletromagnetismo.R
import com.example.eletromagnetismo.utils.sessionManagement.SessionManagment

class Home : Fragment() {

    private lateinit var sessionVerifyer: SessionManagment
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = activity as Context
        sessionVerifyer = SessionManagment(context)
        navController = Navigation.findNavController(view)

        verifySecssion()
    }

    private fun verifySecssion() {
        if (!sessionVerifyer.getInfoSession()){
            navController.navigate(R.id.action_home_to_setUserFragmetn)
        }
    }

}