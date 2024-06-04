package com.example.appandoid.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appandoid.R
import com.example.appandoid.holders.RecViewHolderOffers
import com.example.appandoid.models.CardModel

class RecViewAdapterOffers (private var cardList: List<CardModel>): RecyclerView.Adapter<RecViewHolderOffers>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHolderOffers {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecViewHolderOffers(layoutInflater.inflate(R.layout.item_cell, parent, false))
    }

    override fun getItemCount(): Int = cardList.size

    override fun onBindViewHolder(holder: RecViewHolderOffers, position: Int) {
        val item = cardList[position]
        holder.render(item)
    }
}