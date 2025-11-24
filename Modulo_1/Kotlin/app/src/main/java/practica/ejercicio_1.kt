package com.example.basics

//Semáforo peatonal
//Pide color del semáforo ("rojo", "amarillo", "verde") y si el peatón presionó el botón ("si"/"no").
//
//
//Si está verde y presionó → “Espera a rojo”.
//
//
//Si está rojo → “Cruza”.
//
//
//Si amarillo → “Prepárate”.
//
//
//En otros casos → “Espera”.

fun main(){
    println("Ingrese Un color (rojo,amarillo,verde)")
    var semaforo = readln().toString()
    println("Presione el boton. si/no")
    val p = readln()

    if (semaforo.lowercase() == "verde" && p.lowercase() == "si"){
        println("Esperar a rojo")
    }
    else if(semaforo.lowercase() == "rojo"){
        println("No Cruza")
    }
    else if(semaforo.lowercase() == "amarillo"){
        println("Preparate")
    }
    else{
        println("Espera")
    }
}