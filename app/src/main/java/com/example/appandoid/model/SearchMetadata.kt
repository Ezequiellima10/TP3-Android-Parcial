package com.example.appandoid.model
data class SearchMetadata(
    val id: String,
    val status: String,
    val json_endpoint: String,
    val created_at: String,
    val processed_at: String,
    val google_flights_url: String,
    val raw_html_file: String,
    val prettify_html_file: String,
    val total_time_taken: Double
)