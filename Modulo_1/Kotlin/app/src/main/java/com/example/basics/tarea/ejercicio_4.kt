//1.
//Simulador de ahorro semanal Entrada: meta y ahorro inicial.
// Cada semana sumas +10 a la cantidad semanal que depositas (empieza en 5).
// Imprime semana a semana hasta alcanzar meta.

fun main() {
    println("Ingrese la meta de ahorro:")
    val meta = readln().toFloatOrNull()
    if (meta == null){
        println("Ingrese la meta en numeros")
        return
    }

    println("Ingrese el ahorro inicial:")
    var ahorro = readln().toFloatOrNull()
    if (ahorro == null){
        println("Ingrese la meta en numeros")
        return
    }


    var semana = 1
    var deposito = 5

    while (ahorro < meta) {
        println("Semana $semana: ahorraste $deposito")
        ahorro += deposito
        deposito += 10
        semana++
    }

    println("La meta de ${meta}! se cumplira en la semana ${semana}")
}

