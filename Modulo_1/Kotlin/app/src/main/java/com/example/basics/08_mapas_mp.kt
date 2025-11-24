package com.example.controlinventario

fun main() {
    val inventario = mapOf(
        "Laptop" to 15,
        "Mouse" to 25,
        "Teclado" to 15,
        "Monitor" to 8
    )
    println("Inventario actual es: ${inventario}")

    val productosVendidos = mutableMapOf<String, Int>()
    productosVendidos["Laptop"] = 3
    productosVendidos["Mouse"] = 7
    productosVendidos.put("Teclado", 5)

    println("Productos vendidos: ${productosVendidos}")

    for ((producto, cantidad) in inventario) {
        println("Hay ${cantidad} en stock de este producto -> ${producto}")
    }

    val productosElectronicos = setOf("Laptop", "Mouse", "Teclado", "Monitor", "Tablet")
    val productosEnOferta = setOf("Mouse", "Monitor", "Tablet")

    val enOfertaYEnStock = productosEnOferta intersect inventario.keys
    val todosLosProductos = productosElectronicos union inventario.keys
    val noEnOferta = inventario.keys - productosEnOferta

    println("productos en oferta y en stock: ${enOfertaYEnStock}")
    println("todos los productos conocidos: ${todosLosProductos}")
    println("productos en stock que no están en oferta: $noEnOferta}")
}
