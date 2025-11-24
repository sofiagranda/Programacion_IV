package com.example.basics

//Entrada de cine con descuento por edad
//Pide edad. Base $5.
//
//
//<12 → $3
//
//
//≥65 → $4
//
//
//Si no, $5.


fun main(){
    println("Ingresa tu edad -> ")
    val edad = readln().toInt()

    val precio = ticket(edad)

    println("El precio de tu entrada es $$precio")
}
fun ticket(edad:Int):Int{
    return when{
        edad < 12 -> 5
        edad >= 65 -> 4
        else -> 5
    }
}