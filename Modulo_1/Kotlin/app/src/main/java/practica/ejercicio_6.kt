package com.example.basics

//Calculadora mínima (+ / −)
//Bucle de menú: 1) Sumar 2) Restar 3) Salir. Tras cada operación, mostrar resultado.

fun main(){
    while (true){
        println("Bienvenido a la calculadora")
        println("\nIngrese el primer numero")
        val a = readln().toInt()
        println("Ingrese el segundo numero")
        val b = readln().toInt()
        println("\nQue operacion desea realizar. Escoja una opcion ")
        println("1, suma")
        println("2. restar")
        println("3. salir")
        println("Escoja una opcion")
        val opcion = readln().toInt()

        if (opcion == 1){
            val resultado = a+b
            println("\nEl resultado de ${a} + ${b} es = $resultado")
        }else if (opcion == 2){
            val resultado = a-b
            println("\nEl resultado de ${a} - ${b} es = $resultado")
        }else if (opcion == 3){
            println("\nGracias por usar la calculadora")
            break
        }else{
            println("\nError al ingresar la opcion")
            continue
        }
    }
}