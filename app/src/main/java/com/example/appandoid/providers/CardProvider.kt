package com.example.appandoid.providers

import com.example.appandoid.R
import com.example.appandoid.models.CardModel

class CardProvider {
    companion object{
        val imagesList = listOf(
            CardModel(
                R.drawable.card2,
                "20% discount",
                "for MasterCard users",
                "Limited time offer!!"
            ),
            CardModel(
                R.drawable.card1,
                "25% discount",
                "with your Visa credit cards",
                "Limited time offer!!"
            )
        )
    }
}