package com.example.appandoid.adapters.homeAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appandoid.R
import com.example.appandoid.holders.homeHolders.DestinationViewHolder
import com.example.appandoid.holders.homeHolders.OfferViewHolder
import com.example.appandoid.models.homeModels.OfferModel

class OfferAdapter (private val offerslist: List<OfferModel>) : RecyclerView.Adapter<OfferViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return OfferViewHolder(layoutInflater.inflate(R.layout.item_offer_cell, parent, false))
    }
    override fun getItemCount(): Int = offerslist.size
    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        val offer = offerslist[position]
        holder.title.text = offer.title
        holder.description1.text = offer.title
        holder.description2.text = offer.title
        holder.description3.text = offer.title
        holder.image.setImageResource(offer.imageResourceId)

    }
}