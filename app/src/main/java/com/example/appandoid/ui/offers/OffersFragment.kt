package com.example.appandoid.ui.offers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appandoid.R
import com.example.appandoid.adapters.homeAdapters.OfferAdapter
import com.example.appandoid.models.homeModels.OfferModel



class OffersFragment : Fragment() {
    private lateinit var offerAdapter: OfferAdapter
  /*  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_offers, container, false)

        /*val offersRecyclerView = view.findViewById<RecyclerView>(R.id.rec_card_offers)
        offersRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        offerAdapter = OfferAdapter(OfferProvider.getOffersList(requireContext()))
        offersRecyclerView.adapter = offerAdapter*/


        //-------------------------------------------------------------------------------------
        //val titleMatercard = getString(R.string.offers_rv_tiitulo_mastecard)

        val offersRecyclerView = view.findViewById<RecyclerView>(R.id.rec_card_offers)
        offersRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)


        val titleMatercard = "descuento master"
        val titleVisa = "descuento visa"
        val limitedOffer = "oferta limitada"
        val descripcionVisa = "descrip"
        val descripcionMaster= "descr"
        val descripcionVisa2 = "descrip"
        val descripcionMaster2= "descr"
        val imageMastercard: Int = R.drawable.offer_mastercard
        val imageVisa: Int = R.drawable.offer_visa


        val ofertas = listOf(
            OfferModel(titleMatercard,
                descripcionMaster,
                descripcionMaster2,
                limitedOffer,
                imageMastercard),
            OfferModel(titleVisa,
                descripcionVisa,
                descripcionVisa2,
                limitedOffer,
                imageVisa)
        )

//----------------------------------------------------
        // Initialize the adapter
        offerAdapter = OfferAdapter(ofertas) // Pass an empty list or your data here

        // Set the adapter to the RecyclerView
        offersRecyclerView.adapter = offerAdapter




//---------------------------------------------------
        return inflater.inflate(R.layout.fragment_offers, container, false)
    }


    }
