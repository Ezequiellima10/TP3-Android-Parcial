package com.example.appandoid.providers

import com.example.appandoid.models.homeModels.DestinationModel
import com.example.appandoid.models.homeModels.OfferModel

class OfferProvider {

    companion object{
        val offersList = listOf<OfferModel>(
            OfferModel(
                "20% discount",
                "for",
                "mastercard users",
                "Limited time offer!"),

            OfferModel(
                "25% discount",
                "with",
                "your Visa credit cards",
                "Limited time offer!")

        )



    }
}