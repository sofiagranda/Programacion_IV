package com.example.basics


fun main(){
    println("Mapas")

    val fuerzaJedis = mapOf(
        "Luke" to 85,
        "Obi-wan" to 88,
        "Leia" to 95,
        "Yoda" to 100
    )
    println("Fuerza de los Jedis: ${fuerzaJedis}")

    println("Mapa Mutable")

    val misionesCompletadas =  mutableMapOf<String, Int>()
    misionesCompletadas ["Luke"] = 15
    misionesCompletadas ["Leia"] = 12
    misionesCompletadas.put("Han", 20)

    println("Misiones: ${misionesCompletadas}")

    for((jedi, fuerza) in fuerzaJedis){
        println("$jedi tiene nivel de fuerza $fuerza")
    }

    val planetasVisitados = setOf("Tatooine", "Corusent", "Dagobah")
    println("Planetas visitados : ${planetasVisitados}")

    val planetasPeligrosos = setOf("Mustefer", "Corusent", "Korriban")
    println("Planetas visitados : ${planetasPeligrosos}")

    println("Operaciones de Conjuntos")
    val interseccion = planetasPeligrosos intersect planetasVisitados
    val union = planetasPeligrosos union  planetasVisitados
    val diferencia = planetasPeligrosos - planetasVisitados
    println("Planetas Visitados y peligrosos: ${interseccion}")
    println("Todos los Planetas: ${union}")
    println("Planetas Seguros visitados: ${diferencia}")

}