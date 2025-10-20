package com.example.controlinventario

fun mostrarMensaje() {
    println("Bienvenido al sistema de control de inventario")
}

fun calcularStockInicial(almacen1: Int, almacen2: Int): Int {
    return almacen1 + almacen2
}

fun aplicarDescuento(precio: Int) = precio * 90 / 100

fun stockOperaciones(stockActual: Int, vendidos: Int): Pair<Int, Int> {
    val stockFinal = stockActual - vendidos
    val vendidosConfirmados = vendidos
    return Pair(stockFinal, vendidosConfirmados)
}

fun main() {
    mostrarMensaje()
    val stockTotal = calcularStockInicial(30, 20)
    println(stockTotal)
    println(aplicarDescuento(1500))
    println(stockOperaciones(100, 35))

    val precioConIVA = { precio: Int -> precio * 1.15 }
    val generarMensaje = { producto: String -> "Producto agregado: $producto" }

    println(precioConIVA(200))
    println(generarMensaje("Monitor Curvo"))
}
