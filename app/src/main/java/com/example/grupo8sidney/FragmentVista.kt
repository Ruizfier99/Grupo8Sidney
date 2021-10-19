package com.example.grupo8sidney

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.grupo8sidney.databinding.FragmentVistaBinding
import com.squareup.picasso.Picasso

class FragmentVista : Fragment() {
    private var _binding: FragmentVistaBinding? = null
    private val binding get() = _binding!!

    private val model: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentVistaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var longitudPoi = ""
        var latitudPoi = ""
        model.selected.observe(viewLifecycleOwner, Observer<UbicacionPOI> { ubicacionPOI ->
            binding.tituloPoi.text = ubicacionPOI.nombrePoi
            binding.DescripcionUbica.text = ubicacionPOI.descripcion
            binding.nombreCat.text = "Categoria: " + ubicacionPOI.nombreCategoria
            binding.puntuacionUbi.text = "Puntuación: " + ubicacionPOI.puntuacion
            Picasso.get().load(ubicacionPOI.imagen)
                .into(view.findViewById<ImageView>(R.id.imagenPoi))
            longitudPoi = ubicacionPOI.longitud
            latitudPoi = ubicacionPOI.latitud
        })

        binding.botonGoogle.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:0,0?q=" + latitudPoi + ", " + longitudPoi+"(punto)")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
}