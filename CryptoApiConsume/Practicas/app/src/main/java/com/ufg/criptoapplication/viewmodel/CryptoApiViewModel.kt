package com.ufg.criptoapplication.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.ufg.criptoapplication.api.cryptoapi.CryptoApi
import com.ufg.criptoapplication.api.cryptoapi.CryptoRetrofitHelper
import com.ufg.criptoapplication.api.cryptoapi.dto.CryptoList

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class CryptoApiViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
)  : ViewModel() {
    //Referencia:  https://www.geeksforgeeks.org/retrofit-with-kotlin-coroutine-in-android/


    private val _apiResult= MutableStateFlow<CryptoList>(CryptoList())
    val apiResult = _apiResult.asStateFlow()

    //Aca va la implementacion del RetrofitHelper personalizado
    val cryptoApi = CryptoRetrofitHelper.getInstance().create(CryptoApi::class.java)


    fun loadData(){
        viewModelScope.launch(Dispatchers.IO) {

            val result: Response<CryptoList> = cryptoApi.getBtcUsd()

            // Capturamos el request antes de hacer la llamada
            val request = cryptoApi.getBtcUsd().raw().request()

            try{
                val url = request.url().toString()
                Log.d(TAG, "URI utilizada: $url")



                if (result.isSuccessful) {

                    Log.d(TAG, "Response: ${result.toString()}")

                    if (result.body() != null) {
                        _apiResult.value = result.body()!!
                    } else {
                        Log.e(TAG, "La respuesta está vacía o nula")
                    }
                } else {
                    Log.e(TAG, "Error en la respuesta: ${result.code()}")
                }
            } catch (e: Exception){
                Log.e(TAG, "Error al cargar los datos: ${e.message}")
            }



        }
    }

    companion object{
        const val TAG="CryptoApiViewModel"
    }
}