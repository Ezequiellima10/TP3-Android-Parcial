package com.example.appandoid.providers

import com.example.appandoid.models.homeModels.DestinationModel


class DestinationProvider {
        companion object{
            val destinationList = listOf<DestinationModel>(
                DestinationModel(
                    "Boracay",
                    "Philippines",
                    "5D4N"),
                DestinationModel(
                    "Baros",
                    "Maldives",
                    "7D6N"),
                DestinationModel(
                    "Bali",
                    "Indonesia",
                    "3D2N"),
                DestinationModel(
                    "Palawan",
                    "Philippines",
                    "3D2N"),
                )



        }
    }
