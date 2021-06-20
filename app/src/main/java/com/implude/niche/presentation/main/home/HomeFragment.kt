package com.implude.niche.presentation.main.home

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.implude.niche.R
import com.implude.niche.databinding.FragmentHomeBinding
import com.implude.niche.presentation.EditStoreInfoActivity
import com.implude.niche.presentation.base.BaseFragment
import com.skt.Tmap.TMapMarkerItem
import com.skt.Tmap.TMapPoint
import com.skt.Tmap.TMapView
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val homeViewModel: HomeViewModel by viewModel()
    private val markerNormalBitmap by lazy {
        BitmapFactory.decodeResource(context?.resources, R.drawable.ic_marker_normal)
    }
    private val markerHeartedBitmap by lazy {
        BitmapFactory.decodeResource(context?.resources, R.drawable.ic_marker_hearted)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        val recommendPlaceAdapter = RowPlaceAdapter(this.requireContext())
        val recommendPlaceLayoutManager = LinearLayoutManager(this.requireContext())
        recommendPlaceLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val nearPopularPlaceAdapter = RowPlaceAdapter(this.requireContext())
        val nearPopularPlaceLayoutManager = LinearLayoutManager(this.requireContext())
        nearPopularPlaceLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val nearPopularTopicPlaceAdapter = RowPlaceAdapter(this.requireContext())
        val nearPopularTopicPlaceLayoutManager = LinearLayoutManager(this.requireContext())
        nearPopularTopicPlaceLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        binding.fragmentHomeSlide.recommendStoreRecyclerview.apply {
            this.layoutManager = recommendPlaceLayoutManager
            this.adapter = recommendPlaceAdapter

        }

        binding.fragmentHomeSlide.nearPopularStoreRecyclerview.apply {
            this.layoutManager = nearPopularPlaceLayoutManager
            this.adapter = recommendPlaceAdapter

        }

        binding.fragmentHomeSlide.nearPopularTopicRecyclerview.apply {
            this.layoutManager = nearPopularTopicPlaceLayoutManager
            this.adapter = recommendPlaceAdapter

        }

        val tMapView = initializeTMapView()
        binding.mapContainer.addView(tMapView)

        with(homeViewModel) {
            fetchLocation()
            locationFetchSuccessEvent.observe(viewLifecycleOwner) {
                val location = localDataStore.location ?: return@observe
                recommendPlaceAdapter.location = location
                fetchNearPlace()
                tMapView.setCenterPoint(location.longitude, location.latitude)
            }
            nearPlace.observe(viewLifecycleOwner) {
                recommendPlaceAdapter.items = it
                it.forEach { place ->
                    val (lat, lon) = place.location
                    val marker = TMapMarkerItem().apply {
                        icon = if (place.hearted) markerHeartedBitmap else markerNormalBitmap
                        tMapPoint = TMapPoint(lat, lon)
                        name = place.name
                        setPosition(0.5f, 0.5f)
                    }

                    tMapView.addMarkerItem(place.id, marker)
                }
            }
        }

        binding.fragmentHomeSlide.nicheAdLayout.setOnClickListener {
            startActivity(Intent(context, EditStoreInfoActivity::class.java))
        }

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