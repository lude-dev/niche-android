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
import com.implude.niche.domain.models.*
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

        val placeAdapter = PlaceAdapter(this.requireContext())

        val layoutManager = LinearLayoutManager(this.requireContext())
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.fragmentHomeSlide.recommendStoreRecyclerview.apply {
            this.layoutManager = layoutManager
            this.adapter = placeAdapter
            placeAdapter.data = listOf(
                PlaceModel(
                    id = "id",
                    name = "달떡볶이",
                    location = LocationModel(1.2, 2.3),
                    category = CategoryModel("id", "label"),
                    tags = null, // tag - place infinity loop
                    owner = UserModel("uid","나는야사장","https://www.naver.com/favicon.ico"),
                    verified = true,
                    comments = null, // comments - place infinity loop
                    hearted = true
                ),
                PlaceModel(
                    id = "id",
                    name = "달떡볶이",
                    location = LocationModel(1.2, 2.3),
                    category = CategoryModel("id", "label"),
                    tags = null, // tag - place infinity loop
                    owner = UserModel("uid","나는야사장","https://www.naver.com/favicon.ico"),
                    verified = true,
                    comments = null, // comments - place infinity loop
                    hearted = true
                ),
                PlaceModel(
                    id = "id",
                    name = "달떡볶이",
                    location = LocationModel(1.2, 2.3),
                    category = CategoryModel("id", "label"),
                    tags = null, // tag - place infinity loop
                    owner = UserModel("uid","나는야사장","https://www.naver.com/favicon.ico"),
                    verified = true,
                    comments = null, // comments - place infinity loop
                    hearted = true
                )
            )

        }

        binding.fragmentHomeSlide.popularNearRecyclerview.apply {
            placeAdapter.data = listOf(
                PlaceModel(
                    id = "id",
                    name = "달",
                    location = LocationModel(1.2, 2.3),
                    category = CategoryModel("id", "label"),
                    tags = null, // tag - place infinity loop
                    owner = UserModel("uid","나는야사장","https://www.naver.com/favicon.ico"),
                    verified = true,
                    comments = null, // comments - place infinity loop
                    hearted = true
                ),
                PlaceModel(
                    id = "id",
                    name = "달달",
                    location = LocationModel(1.2, 2.3),
                    category = CategoryModel("id", "label"),
                    tags = null, // tag - place infinity loop
                    owner = UserModel("uid","나는야사장","https://www.naver.com/favicon.ico"),
                    verified = true,
                    comments = null, // comments - place infinity loop
                    hearted = true
                ),
                PlaceModel(
                    id = "id",
                    name = "달달",
                    location = LocationModel(1.2, 2.3),
                    category = CategoryModel("id", "label"),
                    tags = null, // tag - place infinity loop
                    owner = UserModel("uid","나는야사장","https://www.naver.com/favicon.ico"),
                    verified = true,
                    comments = null, // comments - place infinity loop
                    hearted = true
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