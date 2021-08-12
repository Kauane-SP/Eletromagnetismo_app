package com.example.eletromagnetismo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.example.eletromagnetismo.R
import com.example.eletromagnetismo.usecase.vetor.VetorUseCaseImpl
import com.example.eletromagnetismo.utils.VerifyFields

class Vetor : Fragment() {

    private val useCase = VetorUseCaseImpl()

    private lateinit var q: AppCompatEditText
    private lateinit var vx: AppCompatEditText
    private lateinit var vy: AppCompatEditText
    private lateinit var vz: AppCompatEditText
    private lateinit var bx: AppCompatEditText
    private lateinit var by: AppCompatEditText
    private lateinit var bz: AppCompatEditText
    private lateinit var result: AppCompatTextView
    private lateinit var btnCalculate: AppCompatButton
    private lateinit var txtAlert: AppCompatTextView

    companion object {
        fun newInstance() = Vetor()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_vetor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)

        requireActivity().onBackPressed()

        btnCalculate.setOnClickListener {
            val carga = q.text.toString()
            val _vx = vx.text.toString()
            val _vy = vy.text.toString()
            val _vz = vz.text.toString()
            val _bx = bx.text.toString()
            val _by = by.text.toString()
            val _bz = bz.text.toString()

            if(VerifyFields.fieldsVetorEmpity(carga,_vx, _vy, _vz, _bx, _by, _bz)){
                result.text = useCase.calcularVetor(
                    carga,
                    _vx,
                    _vy,
                    _vz,
                    _bx,
                    _by,
                    _bz
                ).replace("E",".10^")
            }else{
                txtAlert.text = getString(R.string.alert_empity_field)
            }
        }
    }

    private fun initView(view: View) {
        q = view.findViewById(R.id.text_const)
        vx = view.findViewById(R.id.text_vector_one)
        vy = view.findViewById(R.id.text_vecto_two)
        vz = view.findViewById(R.id.text_vecto_three)
        bx = view.findViewById(R.id.text_vector_one_b)
        by = view.findViewById(R.id.text_vecto_two_b)
        bz = view.findViewById(R.id.text_vecto_three_b)
        result = view.findViewById(R.id.tv_result_vector)
        btnCalculate = view.findViewById(R.id.bottom_calculate_vector)
        txtAlert = view.findViewById(R.id.txt_alert_vector)
    }


}