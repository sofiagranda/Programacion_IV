//1.
// Termostato doméstico Pide temperatura actual (°C) y preferencia del usuario: “frío”, “templado” o “caliente”.
// Si pref. = “frío” y temp > 22 → “Encender aire”
// Si pref. = “caliente” y temp < 18 → “Encender calefacción”
// Si pref. = “templado” y 18–22 → “En confort”
// En otros casos → “Ventilar”

fun main() {
    println("Ingrese la temperatura actual (grados C) en numeros:")
    val temp = readln().toIntOrNull()

    if (temp == null) {
        println("solo ingrese numeros")
        return
    }

    println("Ingrese su preferencia (frío, templado, caliente):")
    val pref = readln().lowercase()

    val mensaje = when {
        pref !in listOf("frio", "templado", "caliente") -> "Preferencia no reconocida."
        pref == "frio" && temp > 22 -> "Encender aire"
        pref == "templado" && temp in 18..22 -> "En confort"
        pref == "caliente" && temp < 18 -> "Encender calefacción"
        else -> "Ventilar"
    }

    println(mensaje)
}
