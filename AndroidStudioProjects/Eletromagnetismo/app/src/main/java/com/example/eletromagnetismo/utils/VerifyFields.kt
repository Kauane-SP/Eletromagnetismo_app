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
        carga: String,
        _vx: String,
        _vy: String,
        _vz: String,
        _bx: String,
        _by: String,
        _bz: String
    ):Boolean{
        return (
                carga.isNotEmpty() &&
                _vx.isNotEmpty() &&
                _vy.isNotEmpty() &&
                _vz.isNotEmpty() &&
                _bx.isNotEmpty() &&
                _by.isNotEmpty() &&
                _bz.isNotEmpty()
                )
    }
}