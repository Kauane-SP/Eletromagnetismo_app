package com.example.eletromagnetismo.usecase.forca

import java.text.DecimalFormat
import kotlin.math.pow

class ForcaUseCaseImpl : ForcaUseCase {
    override fun calcularForca(
        q: String,
        pq: Int,
        v: String,
        pv: String,
        b: String,
        pb: String
    ) :Double {
        val result =  ((q.toDouble())* 10.0.pow(pq.toDouble())) * (v.toDouble() * b.toDouble()) * 10.0.pow(pv.toDouble() + pb.toDouble())

        return result.toDouble()
    }
}