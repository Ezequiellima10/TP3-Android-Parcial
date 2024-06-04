package com.example.appandoid.services

import com.example.appandoid.model.FlightResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FlightApiService {
    @GET("search")
    fun getFlights(
        @Query("engine") engine: String,
        @Query("api_key") apiKey: String,
        @Query("departure_id") departureId: String,
        @Query("arrival_id") arrivalId: String,
        @Query("outbound_date") outboundDate: String,
        @Query("return_date") returnDate: String
    ): Call<FlightResponse>
}
