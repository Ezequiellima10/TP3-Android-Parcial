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
import com.example.appandoid.adapters.homeAdapters.OfferAdapter
import com.example.appandoid.providers.DestinationProvider
import com.example.appandoid.providers.OfferProvider


class HomeFragment : Fragment() {

    private lateinit var destinationAdapter: DestinationAdapter
    private lateinit var offerAdapter: OfferAdapter
   // override fun onCreate(savedInstanceState: Bundle?) {
    //     super.onCreate(savedInstanceState)
    //     arguments?.let {
    //        param1 = it.getString(ARG_PARAM1)
    //        param2 = it.getString(ARG_PARAM2)
    //    }
    // }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val bannerImage = view.findViewById<ImageView>(R.id.banner_image)
        bannerImage.setImageResource(R.drawable.paris_full_image)


        val destinationsRecyclerView = view.findViewById<RecyclerView>(R.id.rec_destinations)
        destinationsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        destinationAdapter = DestinationAdapter(DestinationProvider.destinationList)
        destinationsRecyclerView.adapter = destinationAdapter

        val offersRecyclerView = view.findViewById<RecyclerView>(R.id.rec_offers)
        offersRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        offerAdapter = OfferAdapter(OfferProvider.offersList)
        offersRecyclerView.adapter = offerAdapter


        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}