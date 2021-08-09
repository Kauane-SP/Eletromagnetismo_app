package com.example.eletromagnetismo.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import coil.load
import com.example.eletromagnetismo.R
import com.example.eletromagnetismo.utils.constants.ConstantsPreferences
import com.example.eletromagnetismo.utils.sessionManagement.SessionManagment
import com.example.eletromagnetismo.view.Slids

class SetUserFragment : Fragment() {

    private lateinit var checkAluno:CheckBox
    private lateinit var checkProfessor:CheckBox
    private lateinit var imgUser:AppCompatImageView
    private lateinit var btnInit:AppCompatButton

    private lateinit var setUserInfo: SessionManagment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_set_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = activity as Context
        setUserInfo = SessionManagment(context)

        initView(view)
        eventBtnListener(context)
    }

    private fun eventCheckBox(context:Context) {
        if (checkAluno.isChecked){
            imgUser.load(R.drawable.ic_book)
            setUserInfo.initializeSession(ConstantsPreferences.ALUNO.toString())
            changeFragment(context)
        }else if(checkProfessor.isChecked){
            imgUser.load(R.drawable.ic_calculator)
            setUserInfo.initializeSession(ConstantsPreferences.PROFESSOR.toString())
            changeFragment(context)
        }
    }

    private fun eventBtnListener(context:Context) {
        btnInit.setOnClickListener {
            eventCheckBox(context)
        }
    }

    private fun changeFragment(context:Context) {
        startActivity(Intent(context, Slids::class.java))
        parentFragmentManager.beginTransaction().remove(this)
    }

    private fun initView(view: View) {
        checkAluno = view.findViewById(R.id.check_aluno)
        checkProfessor = view.findViewById(R.id.check_professor)
        btnInit = view.findViewById(R.id.btn_init)
        imgUser = view.findViewById(R.id.img_user)
    }
}