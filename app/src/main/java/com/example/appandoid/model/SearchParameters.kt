package com.example.appandoid.model
data class SearchParameters(
    val engine: String,
    val hl: String,
    val gl: String,
    val departure_id: String,
    val arrival_id: String,
    val outbound_date: String,
    val return_date: String
)