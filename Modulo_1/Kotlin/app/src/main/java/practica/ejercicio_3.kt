package com.example.basics

//Contador de pares hasta N
//Pide N y cuenta cuántos números pares hay entre 1 y N.


fun main(){
    println("Ingresa un numero para saber cuantos pares hay -> ")
    val n = readln().toInt()

    var contador = 0

    for (i in 1..n){
        if (i % 2 == 0){
            contador += 1
        }
    }
    println("Hay $contador numeros pares")

}