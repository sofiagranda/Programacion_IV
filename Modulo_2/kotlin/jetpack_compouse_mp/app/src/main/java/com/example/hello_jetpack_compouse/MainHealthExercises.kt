package com.example.inventoryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

data class Producto(var id: Int, var nombre: String, var cantidad: Int)

class MainInventory : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { InventarioApp() }
    }
}

@Composable
fun InventarioApp() {
    MaterialTheme {
        Surface(Modifier.fillMaxSize()) {
            InventarioScreen()
        }
    }
}

@Composable
fun InventarioScreen() {
    val productos = remember {
        mutableStateListOf(
            Producto(1, "Laptop", 5),
            Producto(2, "Mouse", 15),
            Producto(3, "Teclado", 10),
            Producto(4, "Monitor", 7)
        )
    }

    var seleccionado by remember { mutableStateOf<Producto?>(null) }
    var nuevoNombre by remember { mutableStateOf("") }
    var nuevaCantidad by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Inventario de productos", style = MaterialTheme.typography.titleLarge)

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(productos, key = { it.id }) { producto ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { seleccionado = producto }
                ) {
                    Column(Modifier.padding(12.dp)) {
                        Text(producto.nombre, style = MaterialTheme.typography.titleMedium)
                        Text("Cantidad: ${producto.cantidad}", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }

        Divider()

        Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
                value = nuevoNombre,
                onValueChange = { nuevoNombre = it },
                label = { Text("Nombre del producto") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = nuevaCantidad,
                onValueChange = { nuevaCantidad = it },
                label = { Text("Cantidad") },
                modifier = Modifier.fillMaxWidth()
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(
                    onClick = {
                        val cantidad = nuevaCantidad.toIntOrNull() ?: 0
                        if (nuevoNombre.isNotBlank() && cantidad > 0) {
                            val id = if (productos.isEmpty()) 1 else productos.maxOf { it.id } + 1
                            productos.add(Producto(id, nuevoNombre, cantidad))
                            nuevoNombre = ""
                            nuevaCantidad = ""
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) { Text("Agregar") }

                Button(
                    onClick = {
                        seleccionado?.let { productos.remove(it) }
                        seleccionado = null
                    },
                    modifier = Modifier.weight(1f)
                ) { Text("Eliminar seleccionado") }
            }
        }

        if (seleccionado != null) {
            var cantidadText by remember { mutableStateOf(seleccionado!!.cantidad.toString()) }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Producto seleccionado:", style = MaterialTheme.typography.titleMedium)
                    Text("Nombre: ${seleccionado!!.nombre}")
                    OutlinedTextField(
                        value = cantidadText,
                        onValueChange = { cantidadText = it },
                        label = { Text("Cantidad") }
                    )
                    Button(onClick = {
                        val newCantidad = cantidadText.toIntOrNull()
                        if (newCantidad != null) seleccionado!!.cantidad = newCantidad
                    }, modifier = Modifier.fillMaxWidth()) {
                        Text("Actualizar cantidad")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInventario() { InventarioApp() }
