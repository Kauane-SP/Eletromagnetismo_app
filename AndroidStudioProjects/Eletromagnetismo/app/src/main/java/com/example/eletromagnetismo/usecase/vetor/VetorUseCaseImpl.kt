package com.example.eletromagnetismo.usecase.vetor

import kotlin.math.pow

class VetorUseCaseImpl : VetorUseCase {

    override fun calcularVetor(
        carga: String,
        _vx: String,
        _vy: String,
        _vz: String,
        _bx: String,
        _by: String,
        _bz: String,
        _elevationVx: String,
        _elevationVy: String,
        _elevationVz: String,
        _elevationBx: String,
        _elevationBy: String,
        _elevationBz: String,
        _elevationCarga: String
    ): String {

        val operation =
            ((((_vy.toDouble() * 10.0.pow(_elevationVy.toDouble())) * (_bz.toDouble() * 10.0.pow(
                _elevationBz.toDouble()
            ))) - ((_vz.toDouble() * 10.0.pow(
                _elevationVz.toDouble()
            )) * (_by.toDouble() * 10.0.pow(_elevationVy.toDouble())))) * (carga.toDouble() * 10.0.pow(
                _elevationCarga.toDouble()
            ))).toString()
                .replace("E", "10^") + " î " +
                    ((((_vz.toDouble() * 10.0.pow(_elevationVz.toDouble())) * (_bx.toDouble() * 10.0.pow(
                        _elevationBx.toDouble()
                    ))) - ((_vx.toDouble() * 10.0.pow(
                        _elevationVx.toDouble()
                    )) * (_bz.toDouble() * 10.0.pow(_elevationBz.toDouble())))) * (carga.toDouble() * 10.0.pow(
                        _elevationCarga.toDouble()
                    ))).toString()
                        .replace("E", "10^") + " j " +
                    ((((_vx.toDouble() * 10.0.pow(_elevationVx.toDouble())) * (_by.toDouble() * 10.0.pow(
                        _elevationBy.toDouble()
                    ))) - ((_vy.toDouble() * 10.0.pow(
                        _elevationVy.toDouble()
                    )) * (_bx.toDouble() * 10.0.pow(_elevationBx.toDouble())))) * (carga.toDouble() * 10.0.pow(
                        _elevationCarga.toDouble()
                    ))).toString()
                        .replace("E", "10^") + " k "

        return operation.toString()
    }
}