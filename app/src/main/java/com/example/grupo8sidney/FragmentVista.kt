package com.example.grupo8sidney

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.grupo8sidney.databinding.FragmentHomeBinding
import com.example.grupo8sidney.databinding.FragmentVistaBinding


class FragmentVista : Fragment() {
    private var _binding: FragmentVistaBinding?=null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentVistaBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //binding."boton".setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_fragmentVista)
        //}


    }


}