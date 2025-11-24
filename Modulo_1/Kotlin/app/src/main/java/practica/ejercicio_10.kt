package com.example.basics

//Promedio y aprobación
//Pide 3 notas (0–20). Promedia y dice “Aprobado” si ≥ 14, si no “Reprobado”.

fun main() {
    val notas = mutableListOf<Double>()

    for (i in 1..3) {
        print("Introduce la nota $i (0-20): ")
        val nota = readLine()?.toDoubleOrNull()

        if (nota == null || nota < 0 || nota > 20) {
            println("Nota inválida, debe ser un número entre 0 y 20.")
            return
        }

        notas.add(nota)
    }

    val promedio = notas.average()
    println("Promedio: %.2f".format(promedio))

    if (promedio >= 14) {
        println("Aprobado")
    } else {
        println("Reprobado")
    }
}
