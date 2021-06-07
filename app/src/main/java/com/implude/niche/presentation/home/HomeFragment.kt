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

        val recommendPlaceAdapter = PlaceAdapter(this.requireContext())
        val recommendPlaceLayoutManager = LinearLayoutManager(this.requireContext())
        recommendPlaceLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val nearPopularPlaceAdapter = PlaceAdapter(this.requireContext())
        val nearPopularPlaceLayoutManager = LinearLayoutManager(this.requireContext())
        nearPopularPlaceLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val nearPopularTopicPlaceAdapter = PlaceAdapter(this.requireContext())
        val nearPopularTopicPlaceLayoutManager = LinearLayoutManager(this.requireContext())
        nearPopularTopicPlaceLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        binding.fragmentHomeSlide.recommendStoreRecyclerview.apply {
            this.layoutManager = recommendPlaceLayoutManager
            this.adapter = recommendPlaceAdapter

        }

        binding.fragmentHomeSlide.nearPopularStoreRecyclerview.apply {
            this.layoutManager = nearPopularPlaceLayoutManager
            this.adapter = nearPopularPlaceAdapter

        }

        binding.fragmentHomeSlide.nearPopularTopicRecyclerview.apply {
            this.layoutManager = nearPopularTopicPlaceLayoutManager
            this.adapter = nearPopularTopicPlaceAdapter

        }

        recommendPlaceAdapter.notifyDataSetChanged()



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