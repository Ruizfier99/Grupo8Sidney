package com.example.grupo8sidney

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val selected= MutableLiveData<UbicacionPOI>()
    fun select(ubicacionPoi:UbicacionPOI){
        selected.value = ubicacionPoi
    }
}
