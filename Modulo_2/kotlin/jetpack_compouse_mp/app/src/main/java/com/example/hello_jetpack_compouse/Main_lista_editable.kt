package com.example.hello_jetpack_compouse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

data class Producto(val id: Int, val nombre: String, var cantidad: Int)

class MainListaInventario : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { InventarioApp() }
    }
}

@Composable
fun InventarioApp() {
    MaterialTheme {
        Surface(Modifier.fillMaxSize()) { InventarioScreen() }
    }
}

@Composable
fun InventarioScreen() {
    var autoId by rememberSaveable { mutableStateOf(4) }
    val productos = remember { 
        mutableStateListOf(
            Producto(1, "Laptop", 5),
            Producto(2, "Mouse", 12),
            Producto(3, "Teclado", 7),
            Producto(4, "Monitor", 3)
        )
    }

    var nombre by rememberSaveable { mutableStateOf("") }
    var cantidad by rememberSaveable { mutableStateOf("") }
    var seleccionado by remember { mutableStateOf<Producto?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Inventario de Productos", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre del producto") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = cantidad,
            onValueChange = { cantidad = it.filter { ch -> ch.isDigit() } },
            label = { Text("Cantidad") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
            TextButton(onClick = { nombre = ""; cantidad = "" }) { Text("Limpiar") }
            Spacer(Modifier.width(8.dp))
            Button(
                onClick = {
                    val n = nombre.trim()
                    val c = cantidad.toIntOrNull() ?: 0
                    if (n.isNotEmpty() && c > 0) {
                        autoId += 1
                        productos.add(Producto(autoId, n, c))
                        nombre = ""; cantidad = ""
                    }
                },
                enabled = nombre.isNotBlank() && cantidad.toIntOrNull() != null
            ) { Text("Agregar") }
        }

        Divider()

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(productos, key = { it.id }) { prod ->
                Card(Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { seleccionado = prod }
                        ) {
                            Text(prod.nombre, style = MaterialTheme.typography.titleMedium)
                            Text("Cantidad: ${prod.cantidad}", style = MaterialTheme.typography.bodyMedium)
                        }
                        TextButton(onClick = {
                            productos.removeIf { it.id == prod.id }
                            if (seleccionado?.id == prod.id) seleccionado = null
                        }) { Text("Eliminar") }
                    }
                }
            }
        }

        if (seleccionado != null) {
            Card(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(12.dp)) {
                    Text("Producto seleccionado:", style = MaterialTheme.typography.titleMedium)
                    Text("ID: ${seleccionado!!.id}")
                    Text("Nombre: ${seleccionado!!.nombre}")
                    Text("Cantidad: ${seleccionado!!.cantidad}")
                }
            }
        } else {
            Text("Selecciona un producto para ver detalles.")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewInventario() { InventarioApp() }
