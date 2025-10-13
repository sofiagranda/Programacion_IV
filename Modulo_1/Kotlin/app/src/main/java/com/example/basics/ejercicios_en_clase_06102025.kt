package com.example.basics


fun main(){
    println("Ejercicios en Clase 1")

        print("Ingresa tu promedio: ")
        val promedio = readlnOrNull()?.toDoubleOrNull() ?: 0.0

        print("¿Trabajas? (si/no): ")
        val trabaja = readlnOrNull()?.trim()?.lowercase()

        val beca = when {
            promedio >= 90 && trabaja == "no" -> "Beca completa"
            promedio >= 90 && trabaja == "si" -> "Beca parcial"
            else -> "Sin beca"
        }

        println("Resultado: $beca")

        print("Ingresa la hora entre 0 y 23: ")
        val hora = readlnOrNull()?.toIntOrNull() ?: 0.0

        val clase = when {
            hora == 7 || hora == 13 -> "Clase en la Mañana"
            hora == 14 || hora == 19 -> "Clase en la tarde"
            else -> "horario lectivo"
        }
        println("Resultado: $clase")

    println("INGRESE EL PRIMER NUMERO")
    val value1: Int = readLine()?.toIntOrNull() ?: 0

    println("Ingrese segundo valor:")
    val value2: Int = readLine()?.toIntOrNull() ?: 0

    println("Ingrese la operación (" +
            "1 SUMA \n" +
            "2 RESTA \n" +
            "3 MULTIPLICACION \n" +
            "4 DIVISION): ")
    val operacion: String = readLine() ?: ""

    when (operacion) {
        "1" -> println("Suma: ${sumar(value1, value2)}")
        "2" -> println("Resta: ${value1 - value2}")
        "3" -> println("Multiplicación: ${value1 * value2}")
        "4" -> {
            if (value2 != 0) {
                println("División: ${value1 / value2}")
            } else {
                println("No se puede dividir por cero")
            }
        }
        else -> println("Operación no válida")
    }
}


