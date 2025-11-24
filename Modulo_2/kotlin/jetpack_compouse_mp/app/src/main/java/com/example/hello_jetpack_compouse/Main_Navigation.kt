package com.example.hello_jetpack_compouse

import android.os.Bundle
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
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
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument

data class ProductoNav(val id: Int, val nombre: String, var cantidad: Int)

class MainInventarioNav : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { InventarioNavApp() }
    }
}

@Composable
fun InventarioNavApp() {
    MaterialTheme {
        Surface(Modifier.fillMaxSize()) {
            val nav = rememberNavController()
            var productos by remember {
                mutableStateOf(
                    mutableListOf(
                        ProductoNav(1, "Laptop", 5),
                        ProductoNav(2, "Mouse", 12),
                        ProductoNav(3, "Teclado", 7),
                        ProductoNav(4, "Monitor", 3)
                    )
                )
            }

            NavHost(navController = nav, startDestination = "home") {
                composable("home") {
                    InventarioHomeScreen(productos) { id, nombre, cantidad ->
                        val safe = URLEncoder.encode(nombre, StandardCharsets.UTF_8.toString())
                        nav.navigate("detail/$id/$safe/$cantidad")
                    }
                }

                composable(
                    route = "detail/{id}/{nombre}/{cantidad}",
                    arguments = listOf(
                        navArgument("id") { type = NavType.IntType },
                        navArgument("nombre") { type = NavType.StringType },
                        navArgument("cantidad") { type = NavType.IntType }
                    )
                ) { backStack ->
                    val id = backStack.arguments?.getInt("id") ?: -1
                    val nombre = backStack.arguments?.getString("nombre") ?: ""
                    val cantidad = backStack.arguments?.getInt("cantidad") ?: 0

                    DetailProductoScreen(
                        id = id,
                        nombre = nombre,
                        cantidadInicial = cantidad,
                        onBack = { nav.popBackStack() },
                        onActualizar = { nuevoValor ->
                            productos.find { it.id == id }?.cantidad = nuevoValor
                            productos = productos.toMutableList()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun InventarioHomeScreen(productos: List<ProductoNav>, onOpenDetail: (Int, String, Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Inventario de Productos", style = MaterialTheme.typography.titleLarge)

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(productos, key = { it.id }) { prod ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onOpenDetail(prod.id, prod.nombre, prod.cantidad) }
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(prod.nombre, style = MaterialTheme.typography.titleMedium)
                        Text("Cantidad: ${prod.cantidad}", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}

@Composable
fun DetailProductoScreen(
    id: Int,
    nombre: String,
    cantidadInicial: Int,
    onBack: () -> Unit,
    onActualizar: (Int) -> Unit
) {
    var cantidad by remember { mutableStateOf(cantidadInicial.toString()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Detalle del Producto", style = MaterialTheme.typography.titleLarge)
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("ID: $id", style = MaterialTheme.typography.titleMedium)
                Text("Nombre: $nombre", style = MaterialTheme.typography.bodyLarge)
                OutlinedTextField(
                    value = cantidad,
                    onValueChange = { cantidad = it },
                    label = { Text("Cantidad") },
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onBack) { Text("Cancelar") }
                    Spacer(Modifier.width(8.dp))
                    Button(onClick = {
                        onActualizar(cantidad.toIntOrNull() ?: cantidadInicial)
                        onBack()
                    }) { Text("Actualizar") }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInventarioHome() {
    InventarioHomeScreen(
        productos = listOf(
            ProductoNav(1, "Laptop", 5),
            ProductoNav(2, "Mouse", 12)
        )
    ) { _, _, _ -> }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetalleProducto() {
    DetailProductoScreen(1, "Laptop", 5, onBack = {}, onActualizar = {})
}
