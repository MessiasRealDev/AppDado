package com.example.atividadedado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.atividadedado.ui.theme.AtividadeDadoTheme
import com.example.atividadedado.R // Import do R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AtividadeDadoTheme {
                Scaffold (modifier = Modifier.fillMaxSize()) {innerPadding ->
                    App()
                }

            }
        }
    }
}

@Composable
fun App(){
    DadoBotaoImagem()
}

@Composable // Composição de função
fun DadoBotaoImagem(modifier: Modifier = Modifier
    .fillMaxSize() // Ocupa toda a tela

){var resultado by remember { mutableStateOf(1) }
    val imagemDado = when (resultado) {

        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    val textoDado = when (resultado) {
        1 -> "Número 1"
        2 -> "Número 2"
        3 -> "Número 3"
        4 -> "Número 4"
        5 -> "Número 5"
        else -> "Número 6"
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = textoDado)
        Image(//(painter = painterResource(id = R.drawable.dice_1),
            painter = painterResource(id = imagemDado), //chama a variável imagemDado menu
            contentDescription = "Face número um")

        Button(onClick = { resultado = (1..6).random() },
        modifier = Modifier.padding(16.dp)){
            Text(stringResource(R.string.botaoLancar))
        }


    }
}

@Preview(showBackground = true)
@Composable
fun DadosPreview() {
    App()
}
@Preview()
@Composable
fun DadosPreview2() {
    App()
}
