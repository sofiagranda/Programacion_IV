package com.example.basics


fun main(){
    println("Listas")
    val inmutable: List<Int> = listOf(1,2,3)
    println("Lista Inmutable ${inmutable}")

    val nutableLista: MutableList<Int> = mutableListOf(4,5,6)
    println("Lista mutable ${nutableLista}")
    nutableLista.add(7)
    println("Lista mutable ${nutableLista}")
    nutableLista.removeAt(0)
    println("Lista mutable ${nutableLista}")

    for (nutable in nutableLista) println(nutable)

    val colores = mutableListOf("rojo", "verde")
    colores.add("azul")
    colores += "amarillo"
    colores.add( 1, "blanco" )
    println(colores)
    colores.remove("verde")
    println(colores)
    colores.removeAt(0)
    println(colores)
    colores[0]="negro"
    println(colores)
    colores.clear()
    println(colores.isEmpty())

    println("Busquedaas con Mutable List")
    val nombres = mutableListOf("juan","luis","pedro")
    println(nombres.find {it.startsWith("l")})
    println(nombres.firstOrNull {it.length>4})
    println(nombres.any {it.contains('j')})
    println(nombres.none {it == "X"})

    println("Ordenamiento con Mutable List")
    val numerosDesordenados = mutableListOf(8,3,2,4,7,2,7,8,6)
    println(numerosDesordenados.sorted())
    println(numerosDesordenados.sortedDescending())
    println(numerosDesordenados.distinct())

    }