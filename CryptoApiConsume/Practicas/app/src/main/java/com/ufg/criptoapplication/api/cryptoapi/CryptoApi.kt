package com.ufg.criptoapplication.api.cryptoapi

import com.ufg.criptoapplication.api.cryptoapi.dto.CryptoList
import retrofit2.Response
import retrofit2.http.GET

interface CryptoApi {

    @GET("/v2/prices/BTC-USD/buy")
    suspend fun getBtcUsd() : Response<CryptoList>
}