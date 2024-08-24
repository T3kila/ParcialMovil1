package com.ufg.criptoapplication.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.ufg.criptoapplication.api.cryptoapi.dto.CryptoList
import kotlinx.coroutines.delay

@Composable
internal fun CryptoApiScreen(uiState: CryptoList?, onLoad: () -> Unit,
                                       onNavigateTo: (conversationId: String) -> Unit= {}
) {

    // Estado para manejar los segundos restantes del temporizador
    var secondsRemaining by remember { mutableStateOf(10) } // (numero entero para Usuario)

    // LaunchedEffect para ejecutar la función en intervalos de tiempo
    LaunchedEffect(Unit) {
        while (true) {
            // Recarga cuando el temporizador llega a 0
            if (secondsRemaining == 0) {
                onLoad()  // Ejecuta la acción de recarga
                secondsRemaining = 10  // Reinicia el temporizador (numero entero para Usuario)
            } else {
                delay(1000L)  // Espera 1 segundo TIEMPO PARA SISTEMA
                secondsRemaining--  // Decrementa los segundos restantes
            }
        }
    }

    LazyColumn{
        item {
            Button(onClick = {
                onLoad()
                secondsRemaining = 10  // Reinicia el temporizador cuando se pulsa manualmente

            }) {
                Text(text = "Recargar con ViewModel ")
            }
        }

        item{
            Text(text = "Alumno: Diego Molina | Parcial 1")
            Divider()
            Text(text = "Crypto: " + uiState!!.data.base)
            Text(text = "Moneda Oficial: " + uiState!!.data.currency)
            Text(text = "Precio Actual: " + uiState!!.data.amount)
            Divider()
            Text(text = "Próxima recarga automática en: $secondsRemaining segundos")

        }


    }

}
