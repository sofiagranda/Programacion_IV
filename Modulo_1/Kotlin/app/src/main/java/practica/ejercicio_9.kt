package com.example.basics

//Tabla de multiplicar (1..10)
//Pide un número y muestra su tabla hasta 10.


fun main(){
    println("Ingresa un numero")
    var n = readln().toInt()
    var tabla = 1

    while (tabla <= 10){
        var resultado = n * tabla

        println("$n * $tabla = $resultado")
        tabla += 1
    }
}