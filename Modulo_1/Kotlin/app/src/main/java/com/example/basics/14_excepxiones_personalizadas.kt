package com.example.basics
class FuerzaInsuficienteException(message: String): Exception(message)
class MisionPeligrosaException(message: String): Exception(message)

fun realizarMision(nivelFuerza: Int, peligroMision: Int): String{

    return try {
        when{
            nivelFuerza<30 -> throw FuerzaInsuficienteException("nivel de fuerza muy bajo:${nivelFuerza}")
            nivelFuerza<80 -> throw FuerzaInsuficienteException("mision extremadamente peligrosa")
            else -> {"error inesperado"}
        }
    } catch (e: FuerzaInsuficienteException){
        "error: ${e.message}. se requiere entrenamiento adicional"
    }catch (e: MisionPeligrosaException){
        "error: ${e.message}. nivel de peligro ${peligroMision}"
    } catch (e: Exception){
        "${e.message}"
    }finally {
        "reporte enviado"
    }
}
fun  main(){
    println(realizarMision(nivelFuerza = 20, peligroMision = 60))
    println(realizarMision(nivelFuerza = 100, peligroMision = 60))
}