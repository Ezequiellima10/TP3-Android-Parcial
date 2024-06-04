import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appandoid.R
import com.example.appandoid.model.Flight
import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.Duration



class FlightAdapter(private val flights: List<Flight>) : RecyclerView.Adapter<FlightAdapter.FlightViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.flight_item, parent, false)
        return FlightViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        val currentFlight = flights[position]

        // Limpiar el nombre del aeropuerto de salida y llegada
        val departureAirportName = cleanAirportName(currentFlight.departure_airport.name)
        val arrivalAirportName = cleanAirportName(currentFlight.arrival_airport.name)

        // Calcular la duración del vuelo
        val duration = calculateDuration(currentFlight.departure_airport.time, currentFlight.arrival_airport.time)

        holder.airline.text = "${currentFlight.airline} Airlines"
        holder.departureAirportName.text = departureAirportName
        holder.departureAirportId.text = currentFlight.departure_airport.id
        holder.arrivalAirportName.text = arrivalAirportName
        holder.arrivalAirportId.text = currentFlight.arrival_airport.id
        holder.travelClass.text = "${currentFlight.travel_class} Class"
        holder.flightDuration.text = duration
        Picasso.get().load(currentFlight.airline_logo).into(holder.airlineLogo)
    }

    fun cleanAirportName(name: String): String {
        val wordsToRemove = listOf("International Airport", "Intercontinental Airport")
        var cleanedName = name
        for (word in wordsToRemove) {
            cleanedName = cleanedName.replace(word, "").trim()
        }
        return cleanedName
    }

    fun calculateDuration(departureTime: String, arrivalTime: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val departure = LocalDateTime.parse(departureTime, formatter)
        val arrival = LocalDateTime.parse(arrivalTime, formatter)

        val duration = Duration.between(departure, arrival)
        val hours = duration.toHours()
        val minutes = duration.toMinutes() % 60

        return "${hours}hr ${minutes}min"
    }

    override fun getItemCount(): Int {
        return flights.size
    }

    inner class FlightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val airline: TextView = itemView.findViewById(R.id.airlineName)
        val departureAirportName: TextView = itemView.findViewById(R.id.departureAirportName)
        val departureAirportId: TextView = itemView.findViewById(R.id.departureAirportId)
        val arrivalAirportName: TextView = itemView.findViewById(R.id.arrivalAirportName)
        val arrivalAirportId: TextView = itemView.findViewById(R.id.arrivalAirportId)
        val travelClass: TextView = itemView.findViewById(R.id.travelClass)
        val airlineLogo: ImageView = itemView.findViewById(R.id.airlineLogo)
        val flightDuration: TextView = itemView.findViewById(R.id.flightDuration)
    }
}