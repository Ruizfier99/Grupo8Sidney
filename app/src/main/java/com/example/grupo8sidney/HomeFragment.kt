package com.example.grupo8sidney
import android.content.ContentValues.TAG
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grupo8sidney.databinding.FragmentHomeBinding
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import java.nio.channels.Selector



class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    private val model: SharedViewModel by activityViewModels()
    private lateinit var  viewModel: viewModelPoi
    private lateinit var postAdapter: UbicacionAdapter


    var contador = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
       // while (contador < 2) {


            //generateUbicaciones()
           //contador += 1
        //}
        initRecycler(puntosInteres)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(viewModelPoi::class.java)
        viewModel.getPois().observe(viewLifecycleOwner, Observer {ubicacionesPoi->
            for(i in ubicacionesPoi){
                puntosInteres.add(i)

            }

        })
        puntosInteres.clear()


        //setOnClickListener{ ubicacionPoi ->
        //  model.select(ubicacionPoi)
        //}

        binding.fabActualizar.setOnClickListener{
            initRecycler(puntosInteres)
        }
        binding.fabSettings.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)

        }






        //binding.rvUbicacionesSidney.setOnClickListener{
        //   findNavController().navigate(R.id.action_homeFragment_to_fragmentVista)
        //}


    }

    val puntosInteres: ArrayList<UbicacionPOI> = arrayListOf(
        //var puntosInteres: ArrayList<UbicacionPOI> = bindingMain.puntosInteres
        // UbicacionPOI("Opera de Sydney",  "Arte y Ocio",  "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Sydney_Opera_House_Sails.jpg/250px-Sydney_Opera_House_Sails.jpg",  "la opera de Sydney", "5 Estrellas" ),
        // UbicacionPOI("Opera de Sydney", "Arte y Ocio",  "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Sydney_Opera_House_Sails.jpg/250px-Sydney_Opera_House_Sails.jpg",  "la opera de Sydney", "5 Estrellas" ),
        //       UbicacionPOI("Opera de Sydney",  "Arte y Ocio",  "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Sydney_Opera_House_Sails.jpg/250px-Sydney_Opera_House_Sails.jpg",  "la opera de Sydney", "5 Estrellas" ),
        //UbicacionPOI("Opera de Sydney", "Arte y Ocio",  "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Sydney_Opera_House_Sails.jpg/250px-Sydney_Opera_House_Sails.jpg",  "la opera de Sydney", "5 Estrellas" )
        //
    )

    //private fun generateUbicaciones() {
      // val ubicacionesString = readPOIJsonFile()

        //try {
          //  val ubicacionesJson = JSONArray(ubicacionesString)

            //for (i in 0 until ubicacionesJson.length()) {
              //  val ubicacionJson = ubicacionesJson.getJSONObject(i)
                //val ubicacion = UbicacionPOI(
                  //  ubicacionJson.getString("nombrePoi"),
                    //ubicacionJson.getString("nombreCategoria"),
                    //ubicacionJson.getString("imagen"),
                    //ubicacionJson.getString("descripcion"),
                    //ubicacionJson.getString("puntuacion")
                //)
                //puntosInteres.add(ubicacion)

            //}
            //print(puntosInteres)

       // } catch (e: JSONException) {
         //   e.printStackTrace()
        //}

    //}

    private fun readPOIJsonFile(): String? {
        var poiString: String? = null

        try {
            val inputStream = requireActivity().assets.open("infoPuntosPou.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            poiString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }


        return poiString
    }


    fun initRecycler(puntoPoi:ArrayList<UbicacionPOI>) {

        val recycler = binding.rvUbicacionesSidney
        recycler.layoutManager = LinearLayoutManager(activity)

        val adapter = UbicacionAdapter(puntoPoi) { ubicacionPOI ->
            contactOnClick(ubicacionPOI)
        }


        recycler.adapter = adapter



    }

    private fun contactOnClick(ubicacionPoi: UbicacionPOI) {
        Log.d(TAG, "Click on: $ubicacionPoi")
        //val bundle= Bundle()
        //val arrays: String = ubicacionPoi.descripcion
        //bundle.putString("ubicacionPoi", arrays)
        //val fragment = FragmentVista()
        //fragment.arguments =bundle
        // fragmentManager?.beginTransaction()?.replace(R.id.textView3,fragment)?.commit()
        model.select(ubicacionPoi)

        findNavController().navigate(R.id.action_homeFragment_to_fragmentVista)


    }




}