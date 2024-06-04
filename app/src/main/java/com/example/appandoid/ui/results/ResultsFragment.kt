package com.example.appandoid.ui.results

import FlightAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appandoid.R
import com.example.appandoid.model.Flight
import com.example.appandoid.model.FlightResponse
import com.example.appandoid.services.FlightApiServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultsFragment : Fragment() {

    private lateinit var flightList: RecyclerView
    private lateinit var flightAdapter: FlightAdapter
    private val TAG = "ResultsFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flightList = view.findViewById(R.id.flight_list)
        flightList.layoutManager = LinearLayoutManager(requireContext())

        loadFlights { flightResponse ->
            if (flightResponse != null) {
                val allFlights = flightResponse.best_flights
                val allFlightItems = mutableListOf<Flight>()

                for (bestFlight in allFlights) {
                    for (flight in bestFlight.flights) {
                        allFlightItems.add(flight)
                    }
                }

                Log.d(TAG, "Flights: $allFlightItems")

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
                    Log.e(TAG, "Error in response: ${response.errorBody()?.string()}")
                    callback(null)
                }
            }

            override fun onFailure(call: Call<FlightResponse>, throwable: Throwable) {
                Log.e(TAG, "Error fetching flights: ${throwable.message}", throwable)
                callback(null)
            }
        })
    }

}
