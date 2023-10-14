package com.example.proyectofinallittlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectofinallittlelemon.ui.theme.LittleLemonColor

@Composable
fun UpperPanel() {
    // Usa un modificador de relleno para
    // El panel entero, en lugar de aplicarlo a cada elemento


    Column(
        modifier = Modifier
            .background(LittleLemonColor.green)
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        // Usa un modificador de alineación para centrar el texto del título y la ubicación
        Text(
            text = stringResource(id = R.string.title),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = LittleLemonColor.yellow,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = stringResource(id = R.string.location),
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = LittleLemonColor.cloud,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(top = 40.dp, bottom = 40.dp)
        ) {
            Text(
                text = stringResource(id = R.string.description),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp,
                color = LittleLemonColor.cloud,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .weight(0.6f) // Usa un modificador de peso para asignar una proporción del ancho al texto
            )
            Image(
                painter = painterResource(id = R.drawable.upperpanelimage),
                contentDescription = "Upper Panel Image",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .weight(0.4f) // Usa un modificador de peso para asignar una proporción del ancho a la imagen
            )
        }
        // Usa un modificador de alineación para centrar el botón
        Button(
            onClick = { },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = LittleLemonColor.yellow,
            )
        ) {
            Text(
                text = stringResource(id = R.string.order_button_text),
                color = Color(0xFF000000)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UpperPanelPreview() {
    UpperPanel()
}