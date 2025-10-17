package com.example.basics

//Contar vocales en una palabra
//Pide texto y cuenta vocales (a,e,i,o,u) sin tildes.

fun contar(texto: String): Int {
    val vocales = listOf('a', 'e', 'i', 'o', 'u')
    var contador = 0
    for (char in texto.lowercase()) {
        if (char in vocales) {
            contador++
        }
    }
    return contador
}

fun main() {
    print("Introduce una palabra o  un texto: ")
    val texto = readLine() ?: ""
    val totalVocales = contar(texto)
    println("La palabra o texto contiene $totalVocales vocales.")
}
