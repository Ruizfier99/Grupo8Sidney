package com.example.grupo8sidney

import com.google.gson.annotations.SerializedName

data class UbicacionPOI(
    @SerializedName("nombrePoi")
    val nombrePoi:String,
    @SerializedName("nombreCategoria")
    val nombreCategoria:String,
    @SerializedName("imagen")
    val imagen:String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("puntuacion")
    val puntuacion: String,
    @SerializedName("longitud")
    val longitud: String,
    @SerializedName("latitud")
    val latitud: String

                        )