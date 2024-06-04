package com.example.appandoid.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appandoid.R
import com.example.appandoid.models.CardModel

class RecViewHolderOffers (view: View) : RecyclerView.ViewHolder(view) {
    val img = view.findViewById<ImageView>(R.id.card_img)
    val discount = view.findViewById<TextView>(R.id.discount)
    val creditCardInfo = view.findViewById<TextView>(R.id.credit_card_info)
    val offerEdition = view.findViewById<TextView>(R.id.offer_edition)

    fun render(model: CardModel){
        discount.text = model.discountText
        creditCardInfo.text = model.cardInfoText
        offerEdition.text = model.limitedOffer
        Glide.with(img.context).load(model.imageResId).into(img)
    }
}