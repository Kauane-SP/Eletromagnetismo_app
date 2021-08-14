package com.example.eletromagnetismo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.example.eletromagnetismo.R
import com.example.eletromagnetismo.usecase.forca.ForcaUseCaseImpl
import com.example.eletromagnetismo.utils.VerifyFields

class Forca : Fragment() {

    companion object {
        fun newInstance() = Forca()
    }

    private var useCase:ForcaUseCaseImpl= ForcaUseCaseImpl()

    private lateinit var cargaEletrica: AppCompatEditText
    private lateinit var produtoVetorial: AppCompatEditText
    private lateinit var potencialProdutoVetorial: AppCompatEditText
    private lateinit var campoEletrico: AppCompatEditText
    private lateinit var potencialCampoEletrico: AppCompatEditText
    private lateinit var result: AppCompatTextView
    private lateinit var btnCalcular: AppCompatButton
    private lateinit var txtAlert: AppCompatTextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_forca, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressed()
        initView(view)
        eventListener()
    }

    private fun eventListener() {
        btnCalcular.setOnClickListener {
            val q = cargaEletrica.text.toString()
            val pq = -19
            val v = produtoVetorial.text.toString()
            val pv = potencialProdutoVetorial.text.toString()
            val b = campoEletrico.text.toString()
            val pb = potencialCampoEletrico.text.toString()

            if(VerifyFields.fieldsForcaEmpity(q,pq,v,pv,b,pb)){
                result.text = useCase.calcularForca(q,pq,v,pv,b,pb).toString().replace("E","10^")
            }else{
                txtAlert.text = getString(R.string.alert_empity_field)
            }
        }

    }

    private fun initView(view: View) {
        cargaEletrica = view.findViewById(R.id.text_carga_eletrica)
        produtoVetorial = view.findViewById(R.id.text_produto_vetorial)
        potencialProdutoVetorial = view.findViewById(R.id.text_potencia_vetorial)
        campoEletrico = view.findViewById(R.id.text_campo_cetorial)
        potencialCampoEletrico = view.findViewById(R.id.text_potencia_campo_vetorial)
        result = view.findViewById(R.id.tv_result)
        btnCalcular = view.findViewById(R.id.bottom_calculate)
        txtAlert = view.findViewById(R.id.tv_alert)
    }
}