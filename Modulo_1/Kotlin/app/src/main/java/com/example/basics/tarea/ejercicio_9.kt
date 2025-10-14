//3.
//Generador de usuario Pide nombre y apellido.
// Con un bucle recorre ambos y construye un username alternando 2 letras del nombre y 2 del apellido.
//Si uno se acaba, sigue con el otro.
//Al final, si longitud < 6, agrega números consecutivos hasta 6.


fun main() {
    println("Ingrese su nombre:")
    val nombre = readln()

    println("Ingrese su apellido:")
    val apellido = readln()

    var username = ""
    var i = 0
    while (i < nombre.length || i < apellido.length) {
        if (i * 2 < nombre.length) {
            username += nombre.substring(i * 2, (i * 2 + 2).coerceAtMost(nombre.length))
        }
        if (i * 2 < apellido.length) {
            username += apellido.substring(i * 2, (i * 2 + 2).coerceAtMost(apellido.length))
        }
        i++
    }

    var num = 1
    while (username.length < 6) {
        username += num
        num++
    }

    println("Username generado: $username")
}
