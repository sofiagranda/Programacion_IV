package com.example.controlinventario

enum class CategoriaProducto(val tipo: String, val prioridad: Int) {
    Tecnologia("Electrónica", 90) {
        override fun descripcion() = "Productos relacionados a computación y dispositivos"
    },
    Oficina("Papelería", 70) {
        override fun descripcion() = "Material de oficina y suministros"
    },
    Hogar("Electrodomésticos", 80) {
        override fun descripcion() = "Artículos para el hogar"
    },
    Entretenimiento("Videojuegos", 85) {
        override fun descripcion() = "Productos para entretenimiento digital"
    };

    abstract fun descripcion(): String

    companion object {
        fun porTipo(tipo: String) = values().find { it.tipo == tipo }
    }
}

class Productos(val categoria: CategoriaProducto, val nombre: String) {
    fun registrar() = "Registrando producto '$nombre' en categoría ${categoria.tipo}"
    fun detalles() = "${categoria.descripcion()} - Prioridad ${categoria.prioridad}"
}

fun main() {
    val producto1 = Productos(CategoriaProducto.Tecnologia, "Laptop HP Envy")
    println(producto1)
    println(producto1.registrar())
    println(producto1.detalles())
}
