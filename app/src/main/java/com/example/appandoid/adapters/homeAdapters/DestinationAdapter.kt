package com.example.appandoid.adapters.homeAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appandoid.R
import com.example.appandoid.holders.homeHolders.DestinationViewHolder
import com.example.appandoid.models.homeModels.DestinationModel

class DestinationAdapter(private val destinationlist: List<DestinationModel>) : RecyclerView.Adapter<DestinationViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DestinationViewHolder(layoutInflater.inflate(R.layout.item_offer_cell, parent, false))
    }
    override fun getItemCount(): Int = destinationlist.size

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) {
        val destination = destinationlist[position]
        holder.render(destination)
    }

}
