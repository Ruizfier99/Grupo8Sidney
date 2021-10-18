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
    private lateinit var postAdapter: UbicacionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        initRecycler(puntosInteres)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(viewModelPoi::class.java)
        viewModel.getPois().observe(viewLifecycleOwner, Observer { ubicacionesPoi ->
            for (i in ubicacionesPoi) {
                puntosInteres.add(i)
            }
        })
        puntosInteres.clear()

        binding.fabActualizar.setOnClickListener {
            initRecycler(puntosInteres)
        }

        binding.fabSettings.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }
    }

    val puntosInteres: ArrayList<UbicacionPOI> = arrayListOf()

    fun initRecycler(puntoPoi: ArrayList<UbicacionPOI>) {
        val recycler = binding.rvUbicacionesSidney
        recycler.layoutManager = LinearLayoutManager(activity)
        val adapter = UbicacionAdapter(puntoPoi) { ubicacionPOI ->
            contactOnClick(ubicacionPOI)
        }
        recycler.adapter = adapter
    }

    private fun contactOnClick(ubicacionPoi: UbicacionPOI) {
        Log.d(TAG, "Click on: $ubicacionPoi")
        model.select(ubicacionPoi)

        findNavController().navigate(R.id.action_homeFragment_to_fragmentVista)
    }
}