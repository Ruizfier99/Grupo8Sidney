package com.example.grupo8sidney
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException


class MainActivity : AppCompatActivity() {
    var puntosInteres: ArrayList<UbicacionPOI> = arrayListOf()
    //var puntosInteres:ArrayList<UbicacionPOI> = listOf(
    //UbicacionPOI("Opera de Sydney",  "Arte y Ocio",  "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Sydney_Opera_House_Sails.jpg/250px-Sydney_Opera_House_Sails.jpg",  "la opera de Sydney", "5 Estrellas" ),
    // UbicacionPOI("Opera de Sydney", "Arte y Ocio",  "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Sydney_Opera_House_Sails.jpg/250px-Sydney_Opera_House_Sails.jpg",  "la opera de Sydney", "5 Estrellas" )
    //)
    private fun generateUbicaciones() {
        val ubicacionesString = readPOIJsonFile()

        try {
            val ubicacionesJson = JSONArray(ubicacionesString)

            for (i in 0 until ubicacionesJson.length()) {
                val ubicacionJson = ubicacionesJson.getJSONObject(i)
                val ubicacion = UbicacionPOI(
                    ubicacionJson.getString("nombrePoi"),
                    ubicacionJson.getString("nombreCategoria"),
                    ubicacionJson.getString("imagen"),
                    ubicacionJson.getString("descripcion"),
                    ubicacionJson.getString("puntuacion")
                )
                puntosInteres.add(ubicacion)

            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
    private fun readPOIJsonFile(): String? {
        var poiString: String? = null
        try {
            val inputStream = assets.open("infoPuntosPou.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            poiString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        print(poiString)

        return poiString
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        initRecycler()
        generateUbicaciones()

    }


    fun initRecycler(){
        findViewById<RecyclerView>(R.id.rvUbicacionesSidney).layoutManager= LinearLayoutManager(this)
        val adapter = UbicacionAdapter(puntosInteres)
        findViewById<RecyclerView>(R.id.rvUbicacionesSidney).adapter= adapter

    }
}