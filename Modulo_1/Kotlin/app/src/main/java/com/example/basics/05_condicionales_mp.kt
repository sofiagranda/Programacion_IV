package con.example.inventario

fun main() {
    println("control de inventario - estructura de control")
    println("condicionales !!!")

    val stock_actual = 8
    val stock_deseado = 10

    if (stock_actual > stock_deseado) {
        println("hay suficiente inventario")
    } else {
        println("se necesita reponer inventario")
    }

    println("clasificacion del producto segun stock")

    var stock: Int = 8

    if (stock > 10) {
        println("stock alto")
    } else if (stock >= 5) {
        println("stock medio")
    } else {
        println("stock bajo")
    }
}
