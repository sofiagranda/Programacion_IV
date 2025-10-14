//4.
//Rally de resistencia Empiezas con 100 de “energía”. En cada etapa (1..N), un número aleatorio 1–3 indica el terreno:
//1 asfalto: −5
//2 tierra: −10
//3 barro: −15 Si energía ≤ 0 → “Abandona en etapa X”. Si termina, “Rally completado con energía Y”.

import kotlin.random.Random

fun main() {
    println("Ingrese la cantidad de etapas:")
    val etapas = readln().toInt()

    var energia = 100

    for (i in 1..etapas) {
        val terreno = Random.nextInt(1, 4)
        val perdida = when (terreno) {
            1 -> 5 // asfalto
            2 -> 10 // tierra
            3 -> 15 // barro
            else -> 0
        }
        energia -= perdida

        println("Etapa $i - Terreno: ${if (terreno == 1) "Asfalto" else if (terreno == 2) "Tierra" else "Barro"} - Energia restante: $energia")

        if (energia <= 0) {
            println("Abandona en etapa $i")
            return
        }
    }

    println("Rally completado con energía $energia")
}
