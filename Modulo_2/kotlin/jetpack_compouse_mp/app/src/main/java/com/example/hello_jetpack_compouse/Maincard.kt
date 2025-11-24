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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.tooling.preview.Preview

data class Producto(var id: Int, var nombre: String, var cantidad: Int)

sealed class InventoryScreen(val route: String) {
    object Home : InventoryScreen("inventory_home")
    object List : InventoryScreen("inventory_list")
}

class MainInventoryNav : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { InventoryNavApp() }
    }
}

@Composable
fun InventoryNavApp() {
    val nav = rememberNavController()
    MaterialTheme {
        Surface(Modifier.fillMaxSize()) {
            NavHost(navController = nav, startDestination = InventoryScreen.Home.route) {
                composable(InventoryScreen.Home.route) { InventoryHomeScreen(nav) }
                composable(InventoryScreen.List.route) { InventoryListScreen(nav) }
            }
        }
    }
}

@Composable
fun InventoryHomeScreen(nav: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text("Control de Inventario", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(20.dp))
        Button(onClick = { nav.navigate(InventoryScreen.List.route) }, modifier = Modifier.fillMaxWidth()) {
            Text("Ver Inventario")
        }
    }
}

@Composable
fun InventoryListScreen(nav: NavController) {
    val productos = remember { mutableStateListOf(
        Producto(1, "Laptop", 5),
        Producto(2, "Mouse", 15),
        Producto(3, "Teclado", 10)
    ) }
    var seleccionado by remember { mutableStateOf<Producto?>(null) }
    var nuevoNombre by remember { mutableStateOf("") }
    var nuevaCantidad by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Inventario de Productos", style = MaterialTheme.typography.titleLarge)

        LazyColumn(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(productos, key = { it.id }) { p ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clickable { seleccionado = p }
                ) {
                    Column(Modifier.padding(12.dp)) {
                        Text(p.nombre, style = MaterialTheme.typography.titleMedium)
                        Text("Cantidad: ${p.cantidad}", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }

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
                    }, modifier = Modifier.weight(1f)
                ) { Text("Agregar") }

                Button(
                    onClick = { seleccionado?.let { productos.remove(it) }; seleccionado = null },
                    modifier = Modifier.weight(1f)
                ) { Text("Eliminar seleccionado") }
            }
        }

        if (seleccionado != null) {
            var cantidadText by remember { mutableStateOf(seleccionado!!.cantidad.toString()) }
            Card(modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
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
                    }, modifier = Modifier.fillMaxWidth()) { Text("Actualizar cantidad") }
                }
            }
        }

        Button(onClick = { nav.navigateUp() }, modifier = Modifier.fillMaxWidth()) {
            Text("Regresar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInventoryNav() { InventoryNavApp() }
