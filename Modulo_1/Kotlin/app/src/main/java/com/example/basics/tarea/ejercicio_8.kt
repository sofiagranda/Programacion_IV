//2.
//ATM simplificado Saldo inicial. En bucle muestra menú: 1) Depositar 2) Retirar 3) Salir.
//Retiro no puede dejar saldo negativo.o
//Cada operación imprime saldo actual. Finaliza con “Sesión terminada”.

fun main() {
    var saldo = 0.0

    while (true) {
        println("\n1) Depositar\n2) Retirar\n3) Salir")
        val opcion = readln()

        when (opcion) {
            "1" -> {
                println("Cantidad a depositar:")
                val cantidad = readln().toDouble()
                saldo += cantidad
                println("Saldo actual: $saldo")
            }
            "2" -> {
                println("Cantidad a retirar:")
                val cantidad = readln().toDouble()
                if (cantidad <= saldo) {
                    saldo -= cantidad
                } else {
                    println("Saldo insuficiente.")
                }
                println("Saldo actual: $saldo")
            }
            "3" -> {
                println("Sesión terminada.")
                break
            }
            else -> println("Opción inválida.")
        }
    }
}
