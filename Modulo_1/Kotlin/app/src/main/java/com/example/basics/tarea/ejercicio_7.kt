//1.
//Cola de supermercado En un while pide “nuevo cliente (total) o fin”.
// Si total > 100 aplica 5% desc.; si lleva más de 10 ítems, mensaje “Caja rápida no disponible”.
// Acumula venta del día y al final muestra total y cantidad de clientes.

fun main() {
    var totalVentas = 0.0
    var clientes = 0

    while (true) {
        println("Ingrese total del cliente o 'fin' para terminar:")
        val entrada = readln()
        if (entrada.lowercase() == "fin") break

        val total = entrada.toDoubleOrNull()
        if (total == null) {
            println("El total ingresado no es válido.")
            continue
        }

        println("¿Cuántos ítems lleva?")
        val items = readln().toIntOrNull()
        if (items == null || items < 1) {
            println("El número de ítems debe ser un número mayor a 0.")
            continue
        }

        var precioTotal = total
        if (precioTotal > 100) {
            precioTotal *= 0.95
        }

        if (items > 10) {
            println("Caja rápida no disponible")
        }

        // Acumula la venta del día
        totalVentas += precioTotal
        clientes++
    }

    println("Total del día: $totalVentas")
    println("Clientes atendidos: $clientes")
}

