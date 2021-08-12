package com.example.eletromagnetismo.usecase.vetor

class VetorUseCaseImpl : VetorUseCase {

    override fun calcularVetor(
        carga: String,
        _vx: String,
        _vy: String,
        _vz: String,
        _bx: String,
        _by: String,
        _bz: String
    ): String {

        val operation = (((_vx.toDouble() * _bz.toDouble()) - (_vz.toDouble() * _by.toDouble())) * carga.toDouble()).toString() + " i " +
                (((_vz.toDouble()* _bx.toDouble()) - (_vx.toDouble() * _bz.toDouble())) * carga.toDouble()).toString() + " j " +
                (((_vx.toDouble() * _by.toDouble()) - (_vy.toDouble() * _bx.toDouble())) * carga.toDouble()).toString() + " k "

        return operation.toString()
    }
}