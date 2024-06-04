package com.example.appandoid.holders.homeHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appandoid.R
import com.example.appandoid.models.homeModels.DestinationModel

class DestinationViewHolder (view: View) : RecyclerView.ViewHolder(view)  {

    val title = view.findViewById<TextView>(R.id.title_destination_item)
    val description = view.findViewById<TextView>(R.id.description_destination_item)
    val code = view.findViewById<TextView>(R.id.code_destination_item)
    val image = view.findViewById<ImageView>(R.id.card_image_destination_item)


    fun render(model: DestinationModel){
        title.text = model.title
        description.text = model.description
        code.text = model.code
        // agregar imagen

    }
}