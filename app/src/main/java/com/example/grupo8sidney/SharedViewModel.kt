package com.example.grupo8sidney

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback

class SharedViewModel : ViewModel() {
    // La variable selected guarda la información del punto de interés seleccionado en la lista
    val selected = MutableLiveData<UbicacionPOI>()

    // Función que guarda la información del POI en la variable selected
    fun select(ubicacionPoi:UbicacionPOI){
        selected.value = ubicacionPoi
    }
}
