package com.implude.niche.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.implude.niche.R
import com.implude.niche.databinding.FragmentHomeBinding
import com.implude.niche.domain.models.CategoryModel
import com.implude.niche.domain.models.LocationModel
import com.implude.niche.domain.models.PlaceModel
import com.implude.niche.domain.models.UserModel
import com.implude.niche.presentation.base.BaseFragment
import com.skt.Tmap.TMapView

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val placeAdapter = RecommendPlaceAdapter(this.requireContext())

        val layoutManager = LinearLayoutManager(this.requireContext())
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.fragmentHomeSlide.recommendStoreRecyclerview.apply {
            this.layoutManager = layoutManager
            this.adapter = placeAdapter
            placeAdapter.items = listOf(
                PlaceModel(
                    name = "달달 무슨달",
                    id = "id",
                    heartQuantity = 25,
                    hearted = true,
                    verified = true,
                    owner = UserModel("id","name",null),
                    category = CategoryModel("id","label"),
                    location = LocationModel(1.1, 1.1),
                    comments = null,
                    tags = null
                ),
                PlaceModel(
                    name = "달달 무슨달",
                    id = "id",
                    heartQuantity = 25,
                    hearted = true,
                    verified = true,
                    owner = UserModel("id","name",null),
                    category = CategoryModel("id","label"),
                    location = LocationModel(1.1, 1.1),
                    comments = null,
                    tags = null
                ),
                PlaceModel(
                    name = "달달 무슨달",
                    id = "id",
                    heartQuantity = 25,
                    hearted = true,
                    verified = true,
                    owner = UserModel("id","name",null),
                    category = CategoryModel("id","label"),
                    location = LocationModel(1.1, 1.1),
                    comments = null,
                    tags = null
                )
            )
        }

        placeAdapter.notifyDataSetChanged()



        val tMapView = initializeTMapView()
        binding.mapContainer.addView(tMapView)

        return binding.root
    }

    private fun initializeTMapView() =
        TMapView(requireContext()).apply {
            setOnApiKeyListener(object : TMapView.OnApiKeyListenerCallback {
                override fun SKTMapApikeySucceed() {
                    Log.d(TAG, "tmap auth succeed")
                }

                override fun SKTMapApikeyFailed(p0: String?) {
                    Log.w(TAG, "tmap auth failed: $p0")
                }
            })
            setSKTMapApiKey(getString(R.string.tmap_api_key))
        }

    companion object {
        const val TAG = "HomeFragment"
    }
}