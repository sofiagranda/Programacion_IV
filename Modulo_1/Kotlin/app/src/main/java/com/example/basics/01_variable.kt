package con.example.basics

fun main(){
    println("VARIABLES")
    val planeta = "Tatooine"
    var jedi = "Anakin"

    jedi = "Obiwan"
    println("Tipos de variables")
    println("Tipos numericos")
    println("Tipos Enero")
    val edad: Int = 25
    println(edad)


    println("Tipo Double")
    val altura: Double = 25.5
    println(altura)


    println("Tipo Float")
    val peso: Float = 25.5f
    println(peso)


    println("Tipo Long")
    val poblacion: Long = 2_000_000_000L
    println(poblacion)


    println("Tipo Texto")
    val nombre: String = "Obi Wan Kenobi"
    println(nombre)


    println("Tipo Char")
    val inicial: Char = '0'
    println(inicial)


    println("Tipo Logico")
    val esJedi: Boolean = true
    println(esJedi)


    println("Nulidad")
    val apellido: String? = null
    println(apellido)


    println("Longitud")
    val ciudad: String? = ""
    println(ciudad?.length)


    println("Operacion de asercion no null")
    val longitudSegura = apellido!!.length

    println("Interpolacion de strings")
    val nombrePrincesa: String = "leia"
    val edadPrincesa: Int = 19
    val planetaPrincesa: String = "Alderan"

    println("${nombrePrincesa.uppercase()} nacio en ${planetaPrincesa}")
    println("En 10 anios tendra: ${edadPrincesa} anios")

    println("String Multilinea")
    val mensaje = """
        Querido $nombre
        Tu mision en $planeta
        ha sido completada exitosamente
        Que la fuerza te acompañe
    """
    println(mensaje)

    println("Conversaciones")
    val textoEdad: String = "25"
    val edadConvertida: Int = textoEdad.toInt()
    println(edadConvertida)

    val numero: Double = 50.8
    val numeroConvertido: String = numero.toString()
    println(numeroConvertido)
}