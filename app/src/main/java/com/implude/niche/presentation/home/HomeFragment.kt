package com.implude.niche.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.implude.niche.R
import com.implude.niche.databinding.FragmentHomeBinding
import com.implude.niche.domain.model.Place
import com.implude.niche.presentation.base.PlaceAdapter
import com.implude.niche.presentation.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val baseAdapter = PlaceAdapter(this.requireContext())

        val layoutManager = LinearLayoutManager(this.requireContext())
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.recommendStoreRecyclerview.layoutManager = layoutManager

        binding.recommendStoreRecyclerview.adapter = baseAdapter

        baseAdapter.data = listOf(
            Place("", "", "asdf", "", 0, 0, ""),
            Place("", "", "asdf", "", 0, 0, ""),
            Place("", "", "asdf", "", 0, 0, "")
        )

        baseAdapter.notifyDataSetChanged()



        return binding.root
    }
}