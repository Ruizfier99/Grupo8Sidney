package com.example.grupo8sidney

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object RetrofitFactory {
    // Constante que guarda la URL del fakeserver donde se almacena el json con la información
    private const val  BASE_URL= "https://my-json-server.typicode.com/Ruizfier99/jsonRepo/"

    private val gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    // Asigna las configuraciones para el Retrofit
    private fun retrofit():Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun apiService():Apiservice = retrofit().create(Apiservice::class.java)
}