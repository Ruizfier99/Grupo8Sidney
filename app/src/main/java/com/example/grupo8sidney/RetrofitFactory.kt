package com.example.grupo8sidney

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object RetrofitFactory {
    private const val  BASE_URL= "https://my-json-server.typicode.com/Ruizfier99/jsonRepo/"
    private val gson: Gson = GsonBuilder()
        .setLenient()
        .create()
    private fun retrofit():Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun apiService():Apiservice= retrofit().create(Apiservice::class.java)
}