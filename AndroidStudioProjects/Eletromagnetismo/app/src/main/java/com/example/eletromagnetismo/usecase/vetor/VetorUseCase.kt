package com.example.eletromagnetismo.usecase.vetor

interface VetorUseCase {
    fun calcularVetor(
        carga:Double,
        _vx:Double,
        _vy:Double,
        _vz:Double,
        _bx:Double,
        _by:Double,
        _bz:Double
    ):String
}