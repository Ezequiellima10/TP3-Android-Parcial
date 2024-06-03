package com.example.appandoid.holders.homeHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appandoid.R
import com.example.appandoid.models.homeModels.OfferModel
import kotlin.io.path.createTempDirectory

class OfferViewHolder (view: View) : RecyclerView.ViewHolder(view)  {

    val title = view.findViewById<TextView>(R.id.title_offer_item)
    val description1 = view.findViewById<TextView>(R.id.description_1_offer_item)
    val description2 = view.findViewById<TextView>(R.id.description_2_offer_item)
    val description3 = view.findViewById<TextView>(R.id.description_3_offer_item)
   // val image = view.findViewById<ImageView>(R.id.card_image_offer_item)
    val image: ImageView = itemView.findViewById(R.id.card_image_offer_item)


}