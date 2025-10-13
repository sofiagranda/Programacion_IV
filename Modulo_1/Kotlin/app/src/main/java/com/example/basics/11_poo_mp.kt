package com.example.controlinventario

data class Producto(
    val nombre: String,
    val stock: Int,
    val precio: Int,
    val proveedor: String? = null
) {
    val categoria: String
        get() = when {
            precio >= 1000 -> "Alta gama"
            precio >= 500 -> "Media"
            else -> "Económico"
        }

    fun requiereReposicion(): Boolean = stock < 10

    fun esPromocionable(): Boolean = precio > 300 && stock > 0
}

fun main() {
    val laptop = Producto(
        "Laptop Lenovo",
        12,
        950,
        "Lenovo Oficial"
    )
    println(laptop)

    val (nombre, stock, precio) = laptop
    println("Producto: $nombre\nStock: $stock\nPrecio: $precio")

    val laptopOferta = laptop.copy(nombre = "Laptop Lenovo Oferta", precio = 800)
    println(laptopOferta)
    println("Categoría de ${laptopOferta.nombre}: ${laptopOferta.categoria}")
    println("¿Requiere reposición? ${laptopOferta.requiereReposicion()}")
}
