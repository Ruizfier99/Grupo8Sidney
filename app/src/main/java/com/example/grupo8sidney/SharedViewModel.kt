package com.example.grupo8sidney

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback

class SharedViewModel : ViewModel() {
    val selected= MutableLiveData<UbicacionPOI>()
    fun select(ubicacionPoi:UbicacionPOI){
        selected.value = ubicacionPoi
    }
}
