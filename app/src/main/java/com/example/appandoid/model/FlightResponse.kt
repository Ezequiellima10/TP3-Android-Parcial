package com.example.appandoid.model
data class FlightResponse(
    val search_metadata: SearchMetadata,
    val search_parameters: SearchParameters,
    val best_flights: List<BestFlight>
)