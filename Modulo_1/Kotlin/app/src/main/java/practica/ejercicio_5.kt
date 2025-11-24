package com.example.basics

//Estado del agua por temperatura
//Pide °C.
//
//
//≤0 → “Sólido”
//
//
//1..99 → “Líquido”
//
//
//≥100 → “Gas”

fun main(){
    println("Ingresa la temperatura -> ")
    val c = readln().toInt()

    val temperatura = estado(c)

    println("El Temperatura del agua esta en estado -> $temperatura")
}
fun estado(temperatura:Int):String{
    return when{
        temperatura <= 0 -> "Solido"
        temperatura in 1..99 -> "liquido"
        else -> "Gas"
    }
}