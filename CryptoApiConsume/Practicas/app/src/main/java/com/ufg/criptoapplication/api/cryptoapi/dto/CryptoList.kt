package com.ufg.criptoapplication.api.cryptoapi.dto

data class CryptoList(
    val data: Data = Data() // Valor predeterminado para evitar que pida parámetros
) {
    data class Data(
        val amount: String = "",  // Valores predeterminados
        val base: String = "",
        val currency: String = ""
    )
}
