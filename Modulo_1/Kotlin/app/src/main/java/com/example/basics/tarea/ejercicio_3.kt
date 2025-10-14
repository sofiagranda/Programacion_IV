//3.
//Control de acceso por horario Entrada: hora (0–23) y rol (“admin”, “invitado”, “empleado”).
//Invitado solo entre 9–17 → “Permitido/Denegado”.
//Empleado entre 6–20.
//Admin siempre.

fun main(){
    println("Cual es tu horario de entrada?")
    val entrada = readln().toIntOrNull()

    if(entrada == null){
        println("Ingrese su entrada en numeros")
        return
    }

    val rol = when{
        entrada in 9..17 -> "Invitado"
        entrada in 6..20 -> "Empleado"
        else -> "Admin"
    }

    println("Acceso consedido. Rol -> ${rol}")
}