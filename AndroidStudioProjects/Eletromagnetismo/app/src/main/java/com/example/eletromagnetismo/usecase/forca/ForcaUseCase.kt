package com.example.eletromagnetismo.usecase.forca

interface ForcaUseCase {

    fun calcularForca(
        q:String,
        pq:Int,
        v:String,
        pv:String,
        b:String,
        pb:String
    ):Double
}