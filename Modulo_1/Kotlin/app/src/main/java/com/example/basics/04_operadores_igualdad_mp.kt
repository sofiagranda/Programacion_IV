package con.example.inventario

fun main() {
    println("control de inventario - operadores de igualdad")

    val producto1: String = "sable de luz"
    val producto2: String = "sable de luz"
    val producto3: String = String("sable de luz".toCharArray())

    println("igualdad estructural")
    println(producto1 == producto2)
    println(producto1 == producto3)

    println("igualdad referencial")
    println(producto1 === producto2)
    println(producto1 === producto3)
}
