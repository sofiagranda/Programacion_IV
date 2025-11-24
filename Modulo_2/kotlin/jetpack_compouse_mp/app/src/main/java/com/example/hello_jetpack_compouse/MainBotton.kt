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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

data class Producto(val id: Int, val nombre: String, var cantidad: Int)

class MainInventario : ComponentActivity() {
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
    var productos by remember {
        mutableStateOf(
            mutableListOf(
                Producto(1, "Laptop", 5),
                Producto(2, "Mouse", 12),
                Producto(3, "Teclado", 7),
                Producto(4, "Monitor", 3)
            )
        )
    }

    var seleccionado by remember { mutableStateOf<Producto?>(null) }
    var nuevaCantidad by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Control de Inventario", style = MaterialTheme.typography.titleLarge)

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(productos) { prod ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            seleccionado = prod
                            nuevaCantidad = prod.cantidad.toString()
                        }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(prod.nombre, style = MaterialTheme.typography.titleMedium)
                        Text("Cantidad: ${prod.cantidad}", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }

        if (seleccionado != null) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    Modifier
                        .padding(12.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text("Editar: ${seleccionado!!.nombre}", style = MaterialTheme.typography.titleMedium)
                    OutlinedTextField(
                        value = nuevaCantidad,
                        onValueChange = { nuevaCantidad = it },
                        label = { Text("Cantidad") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onClick = { seleccionado = null }) { Text("Cancelar") }
                        Spacer(Modifier.width(8.dp))
                        Button(onClick = {
                            val cant = nuevaCantidad.toIntOrNull() ?: 0
                            seleccionado!!.cantidad = cant
                            productos = productos.toMutableList()
                            seleccionado = null
                        }) { Text("Actualizar") }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInventario() { InventarioApp() }
