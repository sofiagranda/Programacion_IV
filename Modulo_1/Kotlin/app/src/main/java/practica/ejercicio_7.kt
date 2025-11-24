package com.example.basics

//Validador simple de contraseña
//Pide contraseña. Válida si tiene ≥8 caracteres y contiene al menos un dígito.

fun validar(contrasena: String): String {
    if (contrasena.length < 8) {
        return "La contrasena debe tener al menos 8 caracteres."
    }
    if (!contrasena.any { it.isDigit() }) {
        return "La contrasena debe contener al menos un numero."
    }
    return "Contrasena valida."
}

fun main() {
    while (true) {
        print("Introduce una contrasena: ")
        val contrasena = readLine() ?: ""

        val resultado = validar(contrasena)
        if (resultado == "Contrasena valida.") {
            println(resultado)
            break
        } else {
            println(resultado)
        }
    }
}
