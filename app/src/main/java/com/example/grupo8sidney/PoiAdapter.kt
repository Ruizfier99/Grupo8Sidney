package com.example.grupo8sidney

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

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
        val (title, description) = mPoi[position]
        holder.titleLabel.text = title
        holder.descLabel.text = description
    }

    override fun getItemCount(): Int {
        return mPoi.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleLabel: TextView = itemView.findViewById(R.id.textView4)
        var descLabel: TextView = itemView.findViewById(R.id.textView5)

        init {
            //itemView.setOnClickListener { showAddContactDialog(adapterPosition) }
        }
    }
}