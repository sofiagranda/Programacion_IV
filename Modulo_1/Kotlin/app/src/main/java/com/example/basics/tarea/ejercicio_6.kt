//3.
//Cuenta regresiva con eventos Desde 30 hasta 0:
//20 → “Chequeo de sistemas”
//10 → “Últimos ajustes”
//0 → “Despegue” En los demás números solo imprime el número.

fun main() {
    for (i in 30 downTo 0) {
        when (i) {
            20 -> println("${i} Chequeo de sistemas")
            10 -> println("${i} Ultimos ajustes")
            0 -> println("${i} Despegue")
            else -> println(i)
        }
    }
}
