//2.
//Detector de vocales consecutivas Pide un texto y recórrelo.
// Cuenta cuántas veces aparecen dos vocales seguidas (aeiou/AEIOU).
// Imprime el total.

fun main() {
    println("Ingrese un texto:")
    val texto = readln()
    val vocales = "aeiouAEIOU"
    var contador = 0

    for (i in 0 until texto.length - 1) {
        if (texto[i] in vocales && texto[i + 1] in vocales) {
            contador++
        }
    }

    println("Total de vocales consecutivas: $contador")
}
