package com.example.grupo8sidney

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.grupo8sidney.databinding.FragmentInicioBinding


class FragmentInicio : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInicioBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)

        binding.listaPOI.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentInicio_to_homeFragment)
        }


        //binding.rvUbicacionesSidney.setOnClickListener{
        //   findNavController().navigate(R.id.action_homeFragment_to_fragmentVista)
        //}


    }



}