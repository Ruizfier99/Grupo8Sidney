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
    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla la vista para el fragmento fragment_inicio usando DataBinding
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        Asigna un clickListener al boton de "mostrar ubicaciones" para redireccionar
        a la lista de puntos de interés
         */
        binding.listaPOI.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentInicio_to_homeFragment)
        }
    }
}