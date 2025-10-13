package con.example.inventario

fun main() {
    println("control de inventario - operaciones aritmeticas")

    val precio_unitario: Double = 10.0
    val cantidad: Double = 5.0
    val descuento: Double = 2.0
    val IVA: Double = 1.5

    println("precio unitario: ${precio_unitario}")
    println("cantidad: ${cantidad}")

    val total_bruto = precio_unitario * cantidad
    println("total bruto: ${total_bruto}")

    val total_con_descuento = total_bruto - descuento
    println("total con descuento: ${total_con_descuento}")

    val total_final = total_con_descuento + IVA
    println("total final con IVA: ${total_final}")

    val precio_promedio = total_final / cantidad
    println("precio promedio por unidad: ${precio_promedio}")
}
