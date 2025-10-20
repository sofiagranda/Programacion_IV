package com.example.controlinventario

fun main() {
    println("Inventario - Listas")

    val productosDisponibles: List<String> = listOf("Laptop", "Mouse", "Teclado")
    println("Productos disponibles: $productosDisponibles")

    val inventarioMutable: MutableList<String> = mutableListOf("Monitor", "Parlantes", "Tablet")
    println("Inventario inicial: $inventarioMutable")
    inventarioMutable.add("Impresora")
    println("Inventario: $inventarioMutable")
    inventarioMutable.removeAt(0)
    println("Inventario: $inventarioMutable")

    for (producto in inventarioMutable) println(producto)

    val nuevosProductos = mutableListOf("Webcam", "Router")
    nuevosProductos.add("Disco Duro")
    nuevosProductos += "Memoria RAM"
    nuevosProductos.add(1, "Micrófono")
    println(nuevosProductos)
    nuevosProductos.remove("Router")
    println(nuevosProductos)
    nuevosProductos.removeAt(0)
    println(nuevosProductos)
    nuevosProductos[0] = "SSD"
    println(nuevosProductos)
    nuevosProductos.clear()
    println(nuevosProductos.isEmpty())

    println("Búsquedas en Inventario")
    val productos = mutableListOf("Laptop", "Teclado", "Tablet", "Mouse")
    println(productos.find { it.startsWith("T") })
    println(productos.firstOrNull { it.length > 6 })
    println(productos.any { it.contains('p') })
    println(productos.none { it == "Celular" })

    println("Ordenamiento de Precios")
    val precios = mutableListOf(1200, 350, 800, 450, 800, 1200, 600)
    println(precios.sorted())
    println(precios.sortedDescending())
    println(precios.distinct())
}
