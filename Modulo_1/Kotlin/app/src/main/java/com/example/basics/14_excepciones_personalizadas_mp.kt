package com.example.controlinventario

class StockInsuficienteException(message: String) : Exception(message)
class EnvioRiesgosoException(message: String) : Exception(message)

fun procesarPedido(stock: Int, riesgoEnvio: Int): String {
    return try {
        when {
            stock < 10 -> throw StockInsuficienteException("Stock insuficiente: $stock unidades")
            riesgoEnvio > 70 -> throw EnvioRiesgosoException("Zona de envío peligrosa")
            else -> "Pedido procesado correctamente"
        }
    } catch (e: StockInsuficienteException) {
        "Error: ${e.message}. Se requiere reposición de inventario"
    } catch (e: EnvioRiesgosoException) {
        "Error: ${e.message}. Riesgo de envío: $riesgoEnvio%"
    } catch (e: Exception) {
        "${e.message}"
    } finally {
        "Reporte generado"
    }
}

fun main() {
    println(procesarPedido(stock = 5, riesgoEnvio = 40))
    println(procesarPedido(stock = 50, riesgoEnvio = 80))
    println(procesarPedido(stock = 100, riesgoEnvio = 20))
}
