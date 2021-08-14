package com.example.eletromagnetismo.usecase.vetor

interface VetorUseCase {
    fun calcularVetor(
        carga:String,
        _vx:String,
        _vy:String,
        _vz:String,
        _bx:String,
        _by:String,
        _bz:String,
        _elevationVx:String,
        _elevationVy: String,
        _elevationVz: String,
        _elevationBx: String,
        _elevationBy: String,
        _elevationBz: String,
        _elevationCarga: String
    ):String
}