package com.example.grupo8sidney

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class UbicacionAdapter(
    val ubicacionPOI: ArrayList<UbicacionPOI>,
    private val onClick: (UbicacionPOI) -> Unit
) : RecyclerView.Adapter<UbicacionAdapter.UbicacionHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UbicacionHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UbicacionHolder(layoutInflater.inflate(R.layout.item_ubicacion, parent, false))
    }

    override fun onBindViewHolder(holder: UbicacionHolder, position: Int) {
        holder.render(ubicacionPOI[position])
    }

    override fun getItemCount(): Int = ubicacionPOI.size

    inner class UbicacionHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private var currentUbicacion: UbicacionPOI? = null

        init {
            view.setOnClickListener {
                currentUbicacion?.let {
                    onClick(it)
                }
            }
        }

        fun render(ubicacionPOI: UbicacionPOI) {
            currentUbicacion = ubicacionPOI

            view.findViewById<TextView>(R.id.tvNombrePoi).text = ubicacionPOI.nombrePoi
            view.findViewById<TextView>(R.id.nombreCategoria).text = ubicacionPOI.nombreCategoria
            view.findViewById<TextView>(R.id.descripcionUbicacion).text = ubicacionPOI.descripcion
            view.findViewById<TextView>(R.id.puntuacionUbicacion).text = ubicacionPOI.puntuacion

            Picasso.get().load(ubicacionPOI.imagen)
                .into(view.findViewById<ImageView>(R.id.ImagenUbi))
        }
    }

    fun updatePoiList(ubicacionPoi: List<UbicacionPOI>?) {
        this.ubicacionPOI.clear()
        ubicacionPoi?.let { this.ubicacionPOI.addAll(it) }
        notifyDataSetChanged()
    }
}