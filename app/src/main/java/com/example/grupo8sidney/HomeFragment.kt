package com.example.grupo8sidney

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grupo8sidney.databinding.FragmentHomeBinding
import java.io.IOException

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val model: SharedViewModel by activityViewModels()
    private lateinit var viewModel: viewModelPoi

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla la vista para el fragmento fragment_home usando DataBinding
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Llama a la función initRecycler para completar la información del RecyclerView
        initRecycler(puntosInteres)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Instancia el ViewModel para gestionar la información de los puntos de interés
        viewModel = ViewModelProvider(this).get(viewModelPoi::class.java)

        /*
         Obtiene la información de los puntos de interes del viewModel y los agrega a la
         lista puntosInteres.
         */
        viewModel.getPois().observe(viewLifecycleOwner, Observer { ubicacionesPoi ->
            for (i in ubicacionesPoi) {
                puntosInteres.add(i)
            }
        })
        puntosInteres.clear()

        // Agrega un ClickListener al botón usado para actualizar el RecyclerView
        binding.fabActualizar.setOnClickListener {
            initRecycler(puntosInteres)
        }

        // Agrega un ClickListener al botón usado para redirigir a la vista de Settings
        binding.fabSettings.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }
    }

    // Lista que guarda la información de los puntos de interés
    val puntosInteres: ArrayList<UbicacionPOI> = arrayListOf()

    // Función que inicializa el RecycleView con la información que hay en la lista/
    fun initRecycler(puntoPoi: ArrayList<UbicacionPOI>) {
        val recycler = binding.rvUbicacionesSidney
        recycler.layoutManager = LinearLayoutManager(activity)

        /*
         Instancia un adaptador con la información de la lista y le pasa en los argumentos
         la función contactOnClick
         */
        val adapter = UbicacionAdapter(puntoPoi) { ubicacionPOI ->
            contactOnClick(ubicacionPOI)
        }
        recycler.adapter = adapter
    }

    // Función que asigna la ruta de navigation entre el homeFragment y el fragmentVista
    private fun contactOnClick(ubicacionPoi: UbicacionPOI) {
        Log.d(TAG, "Click on: $ubicacionPoi")

        /*
         Asigna la información del punto de interés seleccionado a la variable select
         del modelView
         */
        model.select(ubicacionPoi)

        // Redirecciona al framentvista
        findNavController().navigate(R.id.action_homeFragment_to_fragmentVista)
    }
}