package com.example.basics

fun main() {
    var bateria = 100

    while (bateria >= 0) {
        when (bateria) {
            100 -> println(" bateria al ${bateria}% cargadao")
            50 -> println("bateria al ${bateria}% mitad de batería")
            10 -> println("bateria al ${bateria}% conecte cargador")
            0 -> println("bateria al ${bateria}% apagao")
        }
        bateria -= 10
    }
}
