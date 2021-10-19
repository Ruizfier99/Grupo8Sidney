package com.example.grupo8sidney

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class viewModelPoi: ViewModel() {
    private var apiService = RetrofitFactory.apiService()
    private var pois= MutableLiveData<ArrayList<UbicacionPOI>>()
    private var  isFailure= MutableLiveData(false)

    fun getPois(): LiveData<ArrayList<UbicacionPOI>> = pois
    fun getIsFailure(): LiveData<Boolean> = isFailure

    init{
        requestPois()
    }

    fun requestPois(){
        val call=  apiService.requestPoi()
        call.enqueue(object : Callback<ArrayList<UbicacionPOI>?> {
            override fun onResponse(call: Call<ArrayList<UbicacionPOI>?>, response: Response<ArrayList<UbicacionPOI>?>){
                pois.value=response.body()
            }
            override fun onFailure(call: Call<ArrayList<UbicacionPOI>?>, t:Throwable){
                isFailure.value= true
            }

        })
    }
}