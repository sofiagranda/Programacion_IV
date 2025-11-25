package con.example.inventario

fun main() {
    println("CONTROL DE INVENTARIO")

    val nombreProducto: String = "Sable de luz"
    println("Producto: $nombreProducto")

    var cantidad: Int = 15
    println("Cantidad inicial: $cantidad")

    val precioUnitario: Double = 299.99
    println("Precio unitario: $precioUnitario créditos")

    val disponible: Boolean = true
    println("Disponible: $disponible")

    val codigo: String = "SW-001"
    println("Código del producto: $codigo")

    val clasificacion: Char = 'A' // A = Alta calidad
    println("Clasificación: $clasificacion")

    val valorTotal: Double = cantidad * precioUnitario
    println("Valor total en inventario: $valorTotal créditos")

    val ubicacion: String? = null
    println("Ubicación en almacén: $ubicacion")

    println("Nombre del producto tiene ${nombreProducto.length} caracteres")

    println("El producto $nombreProducto con código $codigo cuesta $precioUnitario créditos cada uno.")

    val mensaje = """
        PRODUCTO: $nombreProducto
        CANTIDAD: $cantidad unidades
        PRECIO UNITARIO: $precioUnitario créditos
        DISPONIBLE: $disponible
        UBICACIÓN: ${ubicacion ?: "No asignada"}
    """
    println(mensaje)

    val textoCantidad: String = "10"
    val cantidadExtra: Int = textoCantidad.toInt()
    println("Cantidad extra agregada: $cantidadExtra")

    cantidad += cantidadExtra
    println("Nueva cantidad: $cantidad")

    val totalActualizado: String = (cantidad * precioUnitario).toString()
    println("Nuevo valor total: $totalActualizado créditos")
}
