//2.
//Costo de envío express Entrada: distancia (km) y si llueve (sí/no).
//Si distancia ≤ 5 → base 2.5
//Si 6–15 → base 5
//Si > 15 → base 8
//Si llueve, sumar 1.5. Imprimir “Costo total: …”.


fun main() {
    println("Ingrese la distancia en km")
    val distancia = readln().toFloatOrNull()

    if (distancia == null){
        println("La distancia debe ingresarla en numeros")
        return
    }

    println("Esta lloviendo si / no")
    val llueve = readln().lowercase()

    val base = when{
        distancia <= 5.9 -> 2.5
        distancia in 6.0..15.0 -> 5.0
        else -> 8.0
    }

    val total = if (llueve == "si") base + 1.5 else base

    println(total)
}