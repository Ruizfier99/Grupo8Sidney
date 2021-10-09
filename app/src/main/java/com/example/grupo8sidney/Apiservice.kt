package com.example.grupo8sidney

import retrofit2.Call
import retrofit2.http.GET

interface Apiservice {
    @GET("poi")
    fun requestPoi(): Call<ArrayList<UbicacionPOI>>
}