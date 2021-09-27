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
        //val args= this.arguments
       // val inputData= args?.get("ubicacionPoi")

        //binding.visNombrePoi.text= arrayubi[1].toString()
        //binding.visCategoria.text=arrayubi[3].toString()
        //binding.visdescripcionUbi.text=inputData.toString()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //binding."boton".setOnClickListener{
            //findNavController().navigate(R.id.action_fragmentVista_to_homeFragment)
        //}


    }


}