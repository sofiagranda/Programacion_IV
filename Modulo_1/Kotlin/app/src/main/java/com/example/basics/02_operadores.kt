package con.example.basics

fun main(){
    println("Operadores Logicos !!!")
    val edad: Int = 25
    val entrenamiento: Boolean = true
    val nivel: Int = 8

    val esApto = edad>= 18 && entrenamiento && nivel > 5
    val nesecitoAyuda = !entrenamiento || nivel < 3

    println("Es Apto: ${esApto}")
    println("Nesecito ayuda: ${nesecitoAyuda}")
}