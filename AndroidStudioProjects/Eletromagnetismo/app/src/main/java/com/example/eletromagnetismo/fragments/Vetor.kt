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
import com.example.eletromagnetismo.view.ui.CustomDialog

class Vetor : Fragment() {

    private val useCase = VetorUseCaseImpl()

    private lateinit var customDialog: CustomDialog
    private lateinit var elevationCarga: AppCompatEditText
    private lateinit var elevationVx: AppCompatEditText
    private lateinit var elevationVy: AppCompatEditText
    private lateinit var elevationVz: AppCompatEditText
    private lateinit var elevationBx: AppCompatEditText
    private lateinit var elevationBy: AppCompatEditText
    private lateinit var elevationBz: AppCompatEditText
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
        customDialog = CustomDialog()

        requireActivity().onBackPressed()

        btnCalculate.setOnClickListener {
            val carga = q.text.toString()
            val _vx = vx.text.toString()
            val _vy = vy.text.toString()
            val _vz = vz.text.toString()
            val _bx = bx.text.toString()
            val _by = by.text.toString()
            val _bz = bz.text.toString()
            val _elevationVx = if (elevationVx.text.toString()
                    .isNotEmpty()
            ) elevationVx.text.toString() else " 0.0 "
            val _elevationVy = if (elevationVy.text.toString()
                    .isNotEmpty()
            ) elevationVy.text.toString() else " 0.0 "
            val _elevationVz = if (elevationVz.text.toString()
                    .isNotEmpty()
            ) elevationVz.text.toString() else " 0.0 "
            val _elevationBx = if (elevationBx.text.toString()
                    .isNotEmpty()
            ) elevationBx.text.toString() else " 0.0 "
            val _elevationBy = if (elevationBy.text.toString()
                    .isNotEmpty()
            ) elevationBy.text.toString() else " 0.0 "
            val _elevationBz = if (elevationBz.text.toString()
                    .isNotEmpty()
            ) elevationBz.text.toString() else " 0.0 "
            val _elevationCarga = if (elevationCarga.text.toString()
                    .isNotEmpty()
            ) elevationCarga.text.toString() else "0.0"

            if (VerifyFields.fieldsVetorEmpity(
                    carga,
                    _vx,
                    _vy,
                    _vz,
                    _bx,
                    _by,
                    _bz
                )
            ) {
                result.text = useCase.calcularVetor(
                    carga,
                    _vx,
                    _vy,
                    _vz,
                    _bx,
                    _by,
                    _bz,
                    _elevationVx,
                    _elevationVy,
                    _elevationVz,
                    _elevationBx,
                    _elevationBy,
                    _elevationBz,
                    _elevationCarga
                )
            } else {
                customDialog.dialogInstance(view,"Tente Novamente", "Encontramos campos vazios")
//                txtAlert.text = getString(R.string.alert_empity_field)
            }
        }
    }

    private fun initView(view: View) {
        elevationCarga = view.findViewById(R.id.tv_potencia_q_elevation)
        elevationVx = view.findViewById(R.id.tv_potencia_vx_elevation)
        elevationVy = view.findViewById(R.id.tv_potencia_vy_elevation)
        elevationVz = view.findViewById(R.id.tv_potencia_vz_elevation)
        elevationBx = view.findViewById(R.id.tv_potencia_bx_elevation)
        elevationBy = view.findViewById(R.id.tv_potencia_by_elevation)
        elevationBz = view.findViewById(R.id.tv_potencia_bz_elevation)
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