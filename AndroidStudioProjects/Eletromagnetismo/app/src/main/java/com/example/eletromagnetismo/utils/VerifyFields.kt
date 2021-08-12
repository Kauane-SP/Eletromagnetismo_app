package com.example.eletromagnetismo.utils

object VerifyFields{

    fun fieldsForcaEmpity(
        q: String,
        pq: Int,
        v: String,
        pv: String,
        b: String,
        pb: String
    ):Boolean{
        return (
                q.isNotEmpty() &&
                pq.toString().isNotEmpty() &&
                v.isNotEmpty() &&
                pv.isNotEmpty() &&
                b.isNotEmpty() &&
                pb.isNotEmpty()
                )
    }

    fun fieldsVetorEmpity(
        carga: Double,
        _vx: Double,
        _vy: Double,
        _vz: Double,
        _bx: Double,
        _by: Double,
        _bz: Double
    ):Boolean{
        return (
                carga.toString().isNotEmpty() &&
                _vx.toString().isNotEmpty() &&
                _vy.toString().isNotEmpty() &&
                _vz.toString().isNotEmpty() &&
                _bx.toString().isNotEmpty() &&
                _by.toString().isNotEmpty() &&
                _bz.toString().isNotEmpty()
                )
    }
}