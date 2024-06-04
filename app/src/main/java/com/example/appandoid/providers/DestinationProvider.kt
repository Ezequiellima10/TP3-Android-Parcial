package com.example.appandoid.providers

import com.example.appandoid.R
import com.example.appandoid.models.homeModels.DestinationModel


class DestinationProvider {
        companion object{
            val destinationList = listOf<DestinationModel>(
                DestinationModel(
                    "Boracay",
                    "Philippines",
                    "5D4N",
                     R.drawable.boracay),

                DestinationModel(
                    "Baros",
                    "Maldives",
                    "7D6N",
                    R.drawable.baros),

                DestinationModel(
                    "Bali",
                    "Indonesia",
                    "3D2N",
                    R.drawable.bali),

                DestinationModel(
                    "Palawan",
                    "Philippines",
                    "3D2N",
                    R.drawable.palawan),
                )



        }
    }
