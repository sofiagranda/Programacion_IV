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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument

data class UsuarioNav(val id: Int, val nombre: String)

class Main_Navigation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NavBasicaApp() }
    }
}

@Composable
fun NavBasicaApp() {
    MaterialTheme {
        Surface(Modifier.fillMaxSize()) {
            val nav = rememberNavController()
            NavHost(navController = nav, startDestination = "home") {
                composable("home") {
                    HomeScreen(
                        onOpenDetail = { id, nombre ->
                            // Codificar nombre para URL
                            val safe = URLEncoder.encode(nombre, StandardCharsets.UTF_8.toString())
                            nav.navigate("detail/$id/$safe")
                        }
                    )
                }

                composable(
                    route = "detail/{id}/{nombre}",
                    arguments = listOf(
                        navArgument("id") { type = NavType.IntType },
                        navArgument("nombre") { type = NavType.StringType }
                    )
                ) { backStack ->
                    val id = backStack.arguments?.getInt("id") ?: -1
                    val nombre = backStack.arguments?.getString("nombre") ?: ""
                    DetailScreen(
                        id = id,
                        nombre = nombre,
                        onBack = { nav.popBackStack() }
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(onOpenDetail: (Int, String) -> Unit) {
    val usuarioNavs = remember {
        listOf(
            UsuarioNav(1, "Ana Torres"),
            UsuarioNav(2, "Luis Pérez"),
            UsuarioNav(3, "María López"),
            UsuarioNav(4, "Carlos Ruiz")
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp),
        verticalArrangement = Arrangement.spacedBy(space = 12.dp)
    ) {
        Text(
            text = "Home: selecciona un UsuarioNav",
            style = MaterialTheme.typography.titleLarge
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(space = 8.dp)
        ) {
            items(items = usuarioNavs, key = { it.id }) { user ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onOpenDetail(user.id, user.nombre) }
                ) {
                    Row(
                        modifier = Modifier.padding(all = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "ID: ${user.id} — ${user.nombre}")
                    }
                }
            }
        }
    }
}

@Composable
fun DetailScreen(id: Int, nombre: String, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp),
        verticalArrangement = Arrangement.spacedBy(space = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Detalle", style = MaterialTheme.typography.titleLarge)
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(all = 16.dp),
                verticalArrangement = Arrangement.spacedBy(space = 8.dp)
            ) {
                Text(text = "ID: $id", style = MaterialTheme.typography.titleMedium)
                Text(text = "Nombre: $nombre", style = MaterialTheme.typography.bodyLarge)
            }
        }
        Button(onClick = onBack) {
            Text("⬅️ Volver")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHome() {
    MaterialTheme {
        HomeScreen { _, _ -> }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDetail() {
    MaterialTheme {
        DetailScreen(9, "Ejemplo", onBack = {})
    }
}
