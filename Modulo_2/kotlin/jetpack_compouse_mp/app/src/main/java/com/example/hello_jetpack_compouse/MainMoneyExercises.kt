package com.example.hello_jetpack_compouse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class MoneyScreen(val route: String) {
    object Home : MoneyScreen("money_home")
    object Tip : MoneyScreen("tip")
    object Temperature : MoneyScreen("temperature")
}

class MainMoneyExercises : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MoneyNavApp() }
    }
}

@Composable
fun MoneyNavApp() {
    val nav = rememberNavController()
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavHost(navController = nav, startDestination = MoneyScreen.Home.route) {
                composable(MoneyScreen.Home.route) { MoneyHomeScreen(nav) }
                composable(MoneyScreen.Tip.route) { TipScreen(nav) }
                composable(MoneyScreen.Temperature.route) { TemperatureScreen(nav) }
            }
        }
    }
}

@Composable
fun MoneyHomeScreen(nav: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Herramientas Financieras Diarias",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(20.dp))
        Button(onClick = { nav.navigate(MoneyScreen.Tip.route) }, modifier = Modifier.fillMaxWidth()) {
            Text("Promedio de tres números")
        }
        Spacer(Modifier.height(12.dp))
        Button(onClick = { nav.navigate(MoneyScreen.Temperature.route) }, modifier = Modifier.fillMaxWidth()) {
            Text("Conversor de Temperatura")
        }
    }
}

@Composable
fun TipScreen(nav: NavController) {
    var amount1 by remember { mutableStateOf("") }
    var amount2 by remember { mutableStateOf("") }
    var amount3 by remember { mutableStateOf("") }

    // Calculate average dynamically
    val averageTip = listOf(amount1, amount2, amount3)
        .map { it.replace(",", ".").toDoubleOrNull() ?: 0.0 }
        .average()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Calculadora de Promedio", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)

        OutlinedTextField(amount1, { amount1 = it }, label = { Text("Número 1") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(amount2, { amount2 = it }, label = { Text("Número 2") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(amount3, { amount3 = it }, label = { Text("Número 3") }, modifier = Modifier.fillMaxWidth())

        Text("Promedio = ${"%.2f".format(averageTip)}")

        Button(onClick = { nav.navigateUp() }, modifier = Modifier.fillMaxWidth()) {
            Text("Regresar")
        }
    }
}

@Composable
fun TemperatureScreen(nav: NavController) {
    var celsius by remember { mutableStateOf("") }
    var fahrenheit by remember { mutableStateOf("") }

    val cToF = celsiusToFahrenheitMoney(celsius)
    val fToC = fahrenheitToCelsiusMoney(fahrenheit)

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Conversor de Temperatura", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("De Celsius a Fahrenheit", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(value = celsius, onValueChange = { celsius = it }, label = { Text("Celsius") })
                Text("Resultado: ${"%.2f".format(cToF)} °F")
            }
        }

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("De Fahrenheit a Celsius", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(value = fahrenheit, onValueChange = { fahrenheit = it }, label = { Text("Fahrenheit") })
                Text("Resultado: ${"%.2f".format(fToC)} °C")
            }
        }

        Button(onClick = { nav.navigateUp() }, modifier = Modifier.fillMaxWidth()) {
            Text("Regresar")
        }
    }
}

fun celsiusToFahrenheitMoney(celsius: String): Double {
    val c = celsius.replace(",", ".").toDoubleOrNull() ?: 0.0
    return c * 9.0 / 5.0 + 32.0
}

fun fahrenheitToCelsiusMoney(fahrenheit: String): Double {
    val f = fahrenheit.replace(",", ".").toDoubleOrNull() ?: 0.0
    return (f - 32.0) * 5.0 / 9.0
}

@Preview(showBackground = true)
@Composable
fun PreviewMoneyNav() {
    MoneyNavApp()
}
