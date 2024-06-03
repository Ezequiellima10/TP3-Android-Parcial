package com.example.appandoid

import FlightAdapter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appandoid.model.Flight
import com.example.appandoid.model.FlightResponse
import com.example.appandoid.services.FlightApiServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var flightList: RecyclerView
    private lateinit var flightAdapter: FlightAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flight_list)

        flightList = findViewById(R.id.flight_list)
        flightList.layoutManager = LinearLayoutManager(this)

        loadFlights { flightResponse ->
            if (flightResponse != null) {
                val allFlights = flightResponse.best_flights
                val allFlightItems = mutableListOf<Flight>()

                for (bestFlight in allFlights) {
                    for (flight in bestFlight.flights) {
                        allFlightItems.add(flight)
                    }
                }

                Log.d("Retrofit2", "Posts: $allFlightItems")

                flightAdapter = FlightAdapter(allFlightItems)
                flightList.adapter = flightAdapter
            }
        }
    }


    private fun loadFlights(callback: (FlightResponse?) -> Unit) {
        val service = FlightApiServiceBuilder.create()

        service.getFlights(
            "google_flights",
            "123",
            "",
            "",
            "",
            ""
        ).enqueue(object : Callback<FlightResponse> {

            override fun onResponse(call: Call<FlightResponse>, response: Response<FlightResponse>) {
                if (response.isSuccessful) {
                    val responsePost = response.body()
                    callback(responsePost)
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<FlightResponse>, throwable: Throwable) {
                Log.e(TAG, "Error al traer los vuelos: ${throwable.message}", throwable)
                callback(null)
            }

        })
    }
}
