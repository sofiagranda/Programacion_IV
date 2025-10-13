package con.example.inventario

fun main() {
    println("Control de Inventario - Operadores Lógicos")

    val cantidad: Int = 5
    val stockMinimo: Int = 10
    val productoActivo: Boolean = true
    val calidad: Int = 9

    val necesitaReposicion = cantidad < stockMinimo || !productoActivo
    val sePuedeVender = cantidad >= stockMinimo && productoActivo && calidad >= 7

    println("Cantidad actual: $cantidad")
    println("Stock mínimo: $stockMinimo")
    println("Producto activo: $productoActivo")
    println("Calidad del producto: $calidad/10")

    println("Reponer? $necesitaReposicion")
    println("vender? $sePuedeVender")
}
