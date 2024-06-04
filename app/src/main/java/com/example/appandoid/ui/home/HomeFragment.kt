package com.example.appandoid.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appandoid.R
import com.example.appandoid.adapters.homeAdapters.DestinationAdapter
import com.example.appandoid.providers.DestinationProvider
//import com.example.appandoid.providers.OfferProvider


class HomeFragment : Fragment() {

    private lateinit var destinationAdapter: DestinationAdapter
   // private lateinit var offerAdapter: OfferAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val bannerImage = view.findViewById<ImageView>(R.id.banner_image)
        bannerImage.setImageResource(R.drawable.paris_full_image)


            val destinationsRecyclerView = view.findViewById<RecyclerView>(R.id.rec_destinations)
            destinationsRecyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            destinationAdapter = DestinationAdapter(DestinationProvider.destinationList)
            destinationsRecyclerView.adapter = destinationAdapter

          /*  val offersRecyclerView = view.findViewById<RecyclerView>(R.id.rec_offers)
            offersRecyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            offerAdapter = OfferAdapter(OfferProvider.getOffersList(requireContext()))
            offersRecyclerView.adapter = offerAdapter*/

        return inflater.inflate(R.layout.fragment_home, container, false)
    }















        //-----------------------
        /*val offerList = OfferProvider.getOffersList(requireContext())
        Log.d("HomeFragment", "TAMAÑO DE LA LISTA: ${offerList.size} ----------") // Check offer list size

        if (offerList.isNotEmpty()) {
            offerAdapter = OfferAdapter(offerList)
            offersRecyclerView.adapter = offerAdapter
            Toast.makeText(requireContext(),"LISTA LLENA--${offerList.size}--", Toast.LENGTH_LONG).show()
        } else {
            Log.d("HomeFragment", "-----LISTA VAICA--------")
            Toast.makeText(requireContext(),"LISTA VACIA", Toast.LENGTH_LONG).show()
            // Handle the case where there are no offers to display
        }*/
        //--------------------------------




}