package com.example.proyectofinallittlelemon

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.proyectofinallittlelemon.ui.theme.LittleLemonColor

@Composable
fun LowerPanel(navController: NavHostController, dishes: List<Dish> = listOf()) {
    Column (
    ){
        WeeklySpecialCard()
        LazyColumn {
            itemsIndexed(dishes) { _, dish ->
                MenuDish(navController, dish)
            }
        }
    }
}

@Composable
fun WeeklySpecialCard() {
    Card(
        shape= RoundedCornerShape(0.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.weekly_special),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}



// Usa la anotación OptIn para indicar que estás usando una API experimental
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuDish(navController: NavHostController? = null, dish: Dish) {
    // Crea una tarjeta componible que se ejecuta al hacer clic
    Card(
        shape= RoundedCornerShape(0.dp),
        onClick = {
        // Muestra un mensaje de depuración con el id del plato
        Log.d("AAA", "Click ${dish.id}")
        // Navega a la ruta de los detalles del plato, si el controlador de navegación no es nulo
        navController?.navigate(DishDetails.route + "/${dish.id}")
    }) {
        // Crea una fila componible que contiene una columna y una imagen
        Row(modifier = Modifier
            .fillMaxWidth() // Ocupa todo el ancho disponible
            .padding(8.dp) // Agrega un relleno de 8 dp alrededor de la fila
        ){
            // Crea una columna componible que contiene tres textos
            Column {
                // Muestra el nombre del plato con un estilo y un modificador
                Text(
                    text = dish.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth(0.65f) // Ocupa el 75% del ancho máximo
                        .padding(top = 5.dp, bottom = 5.dp) // Agrega un relleno superior e inferior de 5 dp
                )
                // Muestra la descripción del plato con un estilo y un modificador
                Text(
                    text = dish.description,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .fillMaxWidth(0.65f) // Ocupa el 75% del ancho máximo
                )
                // Muestra el precio del plato con un estilo
                Text(
                    fontWeight = FontWeight.Bold,
                    text = "$ ${dish.price}",
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
            // Muestra la imagen del plato con una descripción y un modificador
            Image(
                painter = painterResource(id = dish.imageResource),
                contentDescription = "Plato de comida",
                modifier = Modifier.padding(start = 20.dp)
                    .clip(shape = RoundedCornerShape(20.dp)) // Recorta la imagen con una forma de esquina redondeada de 10 dp
            )

        }
    }
    // Crea un divisor componible con un modificador, un grosor y un color
    Divider(
        thickness = 3.dp, // Establece el grosor del divisor como 1 dp
        color = LittleLemonColor.yellow // Establece el color del divisor como amarillo
    )
}

@Preview(showBackground = true)
@Composable
fun asdw() {
    WeeklySpecialCard()
}