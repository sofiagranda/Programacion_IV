package com.example.basics

enum class TipoSable(val color: String, val poder: Int){
    Azul("azul",85){
        override fun descripcion() = "Sable tradicional de los Jedi"
    },
    Verdel("Verde",90){
        override fun descripcion() = "Sable de los Jedi consultores"
    },
    rojo("rojo",95){
        override fun descripcion() = "Sable de los Sith"
    },
    morado("morado",95){
        override fun descripcion() = "Sable tradicional de los Jedi"
    };
    abstract fun descripcion(): String
    companion object{
        fun porColor(color: String)= values().find{it.color==color}
    }
}
class Sabledeluz(val tipo: TipoSable, val portador: String){
    fun activar() = "!222run! El sable color ${tipo.color} de ${portador} se enciende"
    fun info()= "${tipo.descripcion()} - Tipo poder ${tipo.poder}"
}

fun main(){
    val sableMindoo = Sabledeluz(TipoSable.morado, portador = "Mindoo")
    println(sableMindoo)
    println(sableMindoo.activar())
    println(sableMindoo.info())
}