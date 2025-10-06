package con.example.inventario

fun main() {
    println("control de inventario - operadores de igualdad")

    val producto1: string = "sable de luz"
    val producto2: string = "sable de luz"
    val producto3: string = string("sable de luz".tochararray())

    println("igualdad estructural")
    println(producto1 == producto2)
    println(producto1 == producto3)

    println("igualdad referencial")
    println(producto1 === producto2)
    println(producto1 === producto3)
}
