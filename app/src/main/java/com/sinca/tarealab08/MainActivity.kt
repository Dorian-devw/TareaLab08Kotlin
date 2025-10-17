package com.sinca.tarealab08


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavegacion()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavegacion() {
    val ctx = LocalContext.current
    val navController = rememberNavController()
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { CenterAlignedTopAppBar(
                title = { Text("TECSUP Campus") },
                actions = { IconButton(onClick = { expanded = true }) { Icon(Icons.Default.MoreVert, contentDescription = "Más opciones") }
                    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false })
                    { val opciones = listOf(
                            "Inicio" to "inicio",
                            "Cursos" to "cursos",
                            "Instructores" to "instructores",
                            "Eventos" to "eventos",
                            "Acerca de" to "acerca"
                        )
                        opciones.forEach { (texto, ruta) ->
                            DropdownMenuItem(
                                text = { Text(texto) },
                                onClick = {
                                    expanded = false
                                    navController.navigate(ruta)
                                    Toast.makeText(ctx, "Abriendo $texto", Toast.LENGTH_SHORT).show()
                                }
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary, titleContentColor = MaterialTheme.colorScheme.onPrimary)
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "inicio",
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp)
        ) { composable("inicio") { PantallaInicio(navController) }
            composable("cursos") { PantallaCursos() }
            composable("instructores") { PantallaInstructores() }
            composable("eventos") { PantallaEventos() }
            composable("acerca") { PantallaAcerca() } }
    }
}

@Composable
fun PantallaInicio(navController: NavHostController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Text("Bienvenido al Campus TECSUP", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        CardInicio("Cursos", R.drawable.imagen1) { navController.navigate("cursos") }
        CardInicio("Instructores", R.drawable.imagen22) { navController.navigate("instructores") }
        CardInicio("Eventos", R.drawable.imagen3) { navController.navigate("eventos") }
    }
}

@Composable
fun CardInicio(titulo: String, imagen: Int, onClick: () -> Unit = {}) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = imagen),
                contentDescription = titulo,
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            )
            Text(
                text = titulo,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun PantallaCursos() {
    val cursos = listOf(
        Triple("Kotlin", "UIs declarativas con Compose", R.drawable.imagen1),
        Triple("Python", "Análisis de datos", R.drawable.imagen22),
        Triple("SQL", "Gestión de bases de datos", R.drawable.imagen3)
    )

    LazyColumn {
        items(cursos.size) { i ->
            CardInicio("${cursos[i].first} – ${cursos[i].second}", cursos[i].third)
        }
    }
}

@Composable
fun PantallaInstructores() {
    val instructores = listOf(
        Triple("Elliot", "Kotlin / Android", R.drawable.imagen1),
        Triple("Silvia", "Gestión de TI", R.drawable.imagen22),
        Triple("Farfán", "Bases de Datos", R.drawable.imagen3)
    )

    LazyColumn {
        items(instructores.size) { i ->
            CardInicio("${instructores[i].first} – ${instructores[i].second}", instructores[i].third)
        }
    }
}

@Composable
fun PantallaEventos() {
    val eventos = listOf(
        Triple("15 Oct", "Feria de Proyectos", "Auditorio A"),
        Triple("22 Oct", "Charla de Innovación", "Sala B"),
        Triple("30 Oct", "ExpoTECSUP", "Patio Central")
    )

    LazyColumn {
        items(eventos.size) { i ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("${eventos[i].first} – ${eventos[i].second}", fontWeight = FontWeight.Bold)
                    Text("Lugar: ${eventos[i].third}")
                }
            }
        }
    }
}

@Composable
fun PantallaAcerca() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("App: TECSUP Campus | Frank Sinca")
            Text("Versión: 1.1.3")
            Text("Autor: Curso TECSUP | Kotlin Lab08")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    AppNavegacion()
}
