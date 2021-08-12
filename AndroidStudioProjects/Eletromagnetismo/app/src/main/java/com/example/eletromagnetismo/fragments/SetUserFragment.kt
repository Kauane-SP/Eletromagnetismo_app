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
import com.example.eletromagnetismo.view.MainActivity
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
        eventCheckBox()
        eventBtnListener(context)
        initializeCheckbox()
    }

    private fun initializeCheckbox() {
        checkAluno.isChecked = true
        imgUser.load(R.drawable.ic_student)
        checkProfessor.isChecked = false
    }

    private fun eventCheckBox() {
        checkAluno.setOnCheckedChangeListener { buttonView, isChecked ->
            if (buttonView.isChecked){
                imgUser.load(R.drawable.ic_reading)
                setUserInfo.initializeSession(ConstantsPreferences.ALUNO.toString())
                checkProfessor.isChecked = false
            }
        }

        checkProfessor.setOnCheckedChangeListener { buttonView, isChecked ->
            if(buttonView.isChecked){
                imgUser.load(R.drawable.ic_teacher)
                setUserInfo.initializeSession(ConstantsPreferences.PROFESSOR.toString())
                checkAluno.isChecked = false
            }
        }
    }

    private fun eventBtnListener(context:Context) {
        btnInit.setOnClickListener {
            changeFragment(context)
        }
    }

    private fun changeFragment(context:Context) {
        startActivity(Intent(context, MainActivity::class.java))
    }

    private fun initView(view: View) {
        checkAluno = view.findViewById(R.id.check_aluno)
        checkProfessor = view.findViewById(R.id.check_professor)
        btnInit = view.findViewById(R.id.btn_init)
        imgUser = view.findViewById(R.id.img_user)
    }

    companion object {
        fun newInstance() = SetUserFragment()
    }
}