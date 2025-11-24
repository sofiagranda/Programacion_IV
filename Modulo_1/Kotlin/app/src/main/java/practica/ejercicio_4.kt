package com.example.basics

//Suma de múltiplos de 3
//Pide N y suma los múltiplos de 3 desde 1..N.

fun main(){
    println("Ingresa un numero -> ")
    val n = readln().toInt()
    var contador = 0
    var suma = 0

    for (i in 1..n){
        if (i % 3 == 0){
            contador += 1
            suma += i
        }
    }
    println("Hay $contador numeros multiplos de 3 y  sumando todos resulta $suma")

}