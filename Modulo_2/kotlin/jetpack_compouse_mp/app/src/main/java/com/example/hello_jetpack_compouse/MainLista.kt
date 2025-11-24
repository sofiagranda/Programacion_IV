package com.example.inventoryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

data class Producto(val id: Int, val nombre: String, val cantidad: Int)

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
        listOf(
            Producto(1, "Laptop", 5),
            Producto(2, "Mouse", 15),
            Producto(3, "Teclado", 10),
            Producto(4, "Monitor", 7)
        )
    }

    var seleccionado by remember { mutableStateOf<Producto?>(null) }

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
                        .background(if (producto == seleccionado) Color(0xFFE0E0E0) else Color.Transparent)
                ) {
                    Column(Modifier.padding(12.dp)) {
                        Text(producto.nombre, style = MaterialTheme.typography.titleMedium)
                        Text("Cantidad: ${producto.cantidad}", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }

        Divider()

        if (seleccionado != null) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Column(Modifier.padding(12.dp)) {
                    Text("Producto seleccionado:", style = MaterialTheme.typography.titleMedium)
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
fun PreviewInventario() { InventarioApp() }
