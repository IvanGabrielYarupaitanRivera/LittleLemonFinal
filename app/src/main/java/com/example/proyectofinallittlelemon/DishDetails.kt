package com.example.proyectofinallittlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectofinallittlelemon.ui.theme.LittleLemonColor

@Composable
fun DishDetails(id: Int) {
    // Obtiene el plato por su id desde el repositorio, o lanza una excepción si no existe
    val dish = requireNotNull(DishRepository.getDish(id))
    // Crea una columna componible que contiene otros elementos
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        // Define el arreglo vertical como spacedBy para agregar un espacio entre cada elemento
        verticalArrangement = Arrangement.spacedBy(10.dp),
        // Define el modificador que se aplica a la columna para cambiar su tamaño, posición, etc.
        modifier = Modifier.fillMaxWidth() // Ocupa todo el ancho disponible
    ) {
        // Muestra la barra superior con el menú y el logo
        TopAppBar()
        // Muestra la imagen del plato con una descripción y un modificador
        Image(
            painter = painterResource(id = dish.imageResource),
            contentDescription = "Dish image",
            modifier = Modifier.fillMaxWidth(), // Ocupa todo el ancho disponible
            contentScale = ContentScale.FillWidth // Escala la imagen para que llene el ancho del contenedor
        )
        // Crea otra columna componible que contiene los detalles del plato
        Column(
            // Define el arreglo vertical como spacedBy para agregar un espacio entre cada elemento
            verticalArrangement=Arrangement.spacedBy(10.dp),
            // Define el modificador que se aplica a la columna para cambiar su tamaño, posición, etc.
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            // Muestra el nombre del plato con un estilo y un modificador
            Text(
                text = dish.name,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            // Muestra la descripción del plato con un estilo y un modificador
            Text(
                text = dish.description,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp,
            )
            // Muestra el contador para seleccionar la cantidad de platos a pedir
            Counter()
            // Crea un botón componible que se ejecuta al hacer clic
            Button(
                onClick = { },
                modifier = Modifier.align(Alignment.CenterHorizontally), // Alinea el botón al centro horizontalmente
                colors = ButtonDefaults.buttonColors(
                containerColor = LittleLemonColor.yellow,
                )
            ) {
                // Muestra el texto del botón con un color y un recurso de cadena
                Text(
                    text = stringResource(id = R.string.add_for) + " $${dish.price}", // Concatena el recurso de cadena con el precio del plato
                    color = Color(0xFF000000)
                )
            }
        }
    }
}

@Composable
fun Counter() {
    // Usa un modificador de alineación para centrar el Row horizontalmente
    Row(
        verticalAlignment=Alignment.CenterVertically,
        horizontalArrangement=Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // Usa un estado mutable para almacenar el valor del contador
        var counter by remember {
            mutableStateOf(1)
        }
        // Crea un botón de texto que decrementa el contador al hacer clic
        TextButton(
            colors = ButtonDefaults.buttonColors(
                containerColor = LittleLemonColor.green,
            ),
            onClick = {
                counter--
            }
        ) {
            Text(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = LittleLemonColor.cloud,
                text = "-",
                style = MaterialTheme.typography.bodyLarge
            )
        }
        // Muestra el valor del contador con un estilo y un modificador
        Text(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = LittleLemonColor.green,
            text = counter.toString(),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(20.dp)
        )
        // Crea un botón de texto que incrementa el contador al hacer clic
        TextButton(
            colors = ButtonDefaults.buttonColors(
                containerColor = LittleLemonColor.green,
            ),
            onClick = {
                counter++
            }
        ) {
            Text(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = LittleLemonColor.cloud,
                text = "+",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
fun DishDetailsPreview() {
    DishDetails(1)
}