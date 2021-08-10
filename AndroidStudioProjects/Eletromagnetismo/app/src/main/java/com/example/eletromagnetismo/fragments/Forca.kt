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

class Forca : Fragment() {

    companion object {
        fun newInstance() = Forca()
    }

    private lateinit var cargaEletrica: AppCompatEditText
    private lateinit var produtoVetorial: AppCompatEditText
    private lateinit var potencialProdutoVetorial: AppCompatEditText
    private lateinit var campoEletrico: AppCompatEditText
    private lateinit var potencialCampoEletrico: AppCompatEditText
    private lateinit var result: AppCompatTextView
    private lateinit var btnCalcular: AppCompatButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_forca, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)
        eventListener()
    }

    private fun eventListener() {
        btnCalcular.setOnClickListener {

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
    }
}