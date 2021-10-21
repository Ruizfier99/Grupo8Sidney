package com.example.grupo8sidney

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        //Carga la vista de la actividad activity_main
        setContentView(R.layout.activity_main)
    }
}