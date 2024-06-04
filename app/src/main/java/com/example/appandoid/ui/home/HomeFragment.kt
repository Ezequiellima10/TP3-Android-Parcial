package com.example.appandoid.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appandoid.R
import com.example.appandoid.adapters.RecViewAdapterOffers
import com.example.appandoid.adapters.homeAdapters.DestinationAdapter
import com.example.appandoid.databinding.FragmentHomeBinding
import com.example.appandoid.databinding.FragmentSearchBinding
import com.example.appandoid.providers.CardProvider
import com.example.appandoid.providers.DestinationProvider
//import com.example.appandoid.providers.OfferProvider


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var destinationAdapter: DestinationAdapter



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        initDestinationsRecycleView()
        initOffersRecycleView()
      // val bannerImage = view.findViewById<ImageView>(R.id.banner_image)
       // bannerImage.setImageResource(R.drawable.paris_full_image)
        return binding.root

        //

        /*_binding = FragmentSearchBinding.inflate(inflater, container, false)
        initRecycleView()
        binding.searchBtn.setOnClickListener{
            if(validateForm()){
                resetForm()
                this.findNavController().navigate(R.id.action_searchFragment_to_resultsFragment)
            }
        }
        return binding.root*/

        ///


           /* val destinationsRecyclerView = view.findViewById<RecyclerView>(R.id.rec_destinations)
            destinationsRecyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            destinationAdapter = DestinationAdapter(DestinationProvider.destinationList)
            destinationsRecyclerView.adapter = destinationAdapter*/

          /*  val offersRecyclerView = view.findViewById<RecyclerView>(R.id.rec_offers)
            offersRecyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            offerAdapter = OfferAdapter(OfferProvider.getOffersList(requireContext()))
            offersRecyclerView.adapter = offerAdapter*/

        return inflater.inflate(R.layout.fragment_home, container, false)

        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.home_fragment, container, false)



    }

    private fun initOffersRecycleView() {
        val adapter = RecViewAdapterOffers(CardProvider.imagesList)
        binding.recOffers.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recOffers.adapter = adapter
    }

    private fun initDestinationsRecycleView() {
        val adapter = DestinationAdapter(DestinationProvider.destinationList)
        binding.recDestinations.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recDestinations.adapter = adapter
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