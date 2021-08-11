package com.example.eletromagnetismo.usecase.vetor

class VetorUseCaseImpl : VetorUseCase {

    override fun calcularVetor(
        carga: Double,
        _vx: Double,
        _vy: Double,
        _vz: Double,
        _bx: Double,
        _by: Double,
        _bz: Double
    ): String {

        val operation = (((_vx * _bz) - (_vz * _by)) * carga).toString() + " i " +
                (((_vz * _bx) - (_vx * _bz)) * carga).toString() + " j " +
                (((_vx * _by) - (_vy * _bx)) * carga).toString() + " k "

        return operation.toString()
    }
}