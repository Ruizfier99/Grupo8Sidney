package com.example.grupo8sidney

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class viewModelPoi: ViewModel() {

    private var apiService = RetrofitFactory.apiService()
    private var pois = MutableLiveData<ArrayList<UbicacionPOI>>()
    private var isFailure = MutableLiveData(false)

    fun getPois(): LiveData<ArrayList<UbicacionPOI>> = pois
    fun getIsFailure(): LiveData<Boolean> = isFailure

    init{
        requestPois()
    }

    /*
     Función que por medio de Retrofit hace el llamado al servidor donde se almacena la información
     de los puntos de interes
     */
    fun requestPois(){
        val call = apiService.requestPoi()
        call.enqueue(object : Callback<ArrayList<UbicacionPOI>?> {
            // En caso de que el callback sea exitoso asigna la información a la variable pois
            override fun onResponse(call: Call<ArrayList<UbicacionPOI>?>,
                                    response: Response<ArrayList<UbicacionPOI>?>)
            {
                pois.value = response.body()
            }
            // En caso de que el callback falle, asigna true a isFailure
            override fun onFailure(call: Call<ArrayList<UbicacionPOI>?>, t:Throwable){
                isFailure.value = true
            }
        })
    }
}