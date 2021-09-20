package com.example.grupo8sidney

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PoiAdapter internal constructor(private val mPoi: ArrayList<Poi>) :
    RecyclerView.Adapter<PoiAdapter.ViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ) : ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.poi_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val (title, description, image) = mPoi[position]

        holder.titleLabel.text = title
        holder.descLabel.text = description

        Picasso.get().load(image).into(holder.imageUrl)
    }

    override fun getItemCount(): Int {
        return mPoi.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var titleLabel: TextView = view.findViewById(R.id.tvName)
        var descLabel: TextView = view.findViewById(R.id.tvDesc)
        var imageUrl: ImageView = view.findViewById(R.id.imageView3)

        init {
            //itemView.setOnClickListener { showAddContactDialog(adapterPosition) }
        }
    }
}