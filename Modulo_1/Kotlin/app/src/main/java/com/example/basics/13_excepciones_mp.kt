package com.example.controlinventario

fun main() {
    try {
        val stock = 0
        val totalPrecio = 1500
        val precioUnitario = totalPrecio / stock
        println("Precio por unidad: $precioUnitario")
    } catch (e: Exception) {
        println(e)
        println("Error al calcular el precio por unidad")
    }
}
