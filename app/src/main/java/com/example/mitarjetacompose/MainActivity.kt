package com.example.mitarjetacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aquí llamamos a nuestro composable principal
            MiTarjetaDePresentacion()
        }
    }
}

@Composable
fun MiTarjetaDePresentacion() {
    // Variable de estado: guarda el nombre que escribe el usuario
    var nombre by remember { mutableStateOf("") }

    // Variable de estado: guarda el mensaje de saludo
    var saludo by remember { mutableStateOf("Aquí aparecerá tu saludo") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Tarjeta de Presentación",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = nombre, // Ahora está vinculado a la variable
            onValueChange = { nombre = it }, // Se actualiza al escribir
            label = { Text("Escribe tu nombre") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // Al hacer clic, actualizamos el saludo
            saludo = "¡Hola, $nombre! Bienvenido a Compose."
        }) {
            Text("Saludar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = saludo) // Muestra el saludo actualizado
    }
}

