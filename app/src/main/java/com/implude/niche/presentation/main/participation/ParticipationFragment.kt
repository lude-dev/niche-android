package com.implude.niche.presentation.main.participation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.implude.niche.R
import com.implude.niche.databinding.FragmentParticipationBinding
import com.implude.niche.domain.models.*
import com.implude.niche.presentation.EditStoreInfoActivity
import com.implude.niche.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ParticipationFragment : BaseFragment<FragmentParticipationBinding>(R.layout.fragment_participation) {

    private val participationViewModel: ParticipationViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        val lackInfoPlaceAdapter = NeedFixPlaceAdapter(this.requireContext())
        val lackInfoPlaceLayoutManager = LinearLayoutManager(this.requireContext())

        binding.lackInformationRecyclerview.apply {
            this.layoutManager = lackInfoPlaceLayoutManager
            this.adapter = lackInfoPlaceAdapter
            lackInfoPlaceAdapter.items = listOf(
                PlaceModel(
                    name = "달달",
                    id = "id",
                    heartQuantity = 5,
                    tags = listOf(TagModel("sdf","sdf",null)),
                    comments = listOf(CommentModel("sdf", listOf("sdf", "sdf"),null, UserModel("sdf","sdf","sdf"))),
                    location = LocationModel(1.1, 1.1),
                    category = CategoryModel("id", "label"),
                    owner = null,
                    verified = true,
                    hearted = false
                ),
                PlaceModel(
                    name = "달달",
                    id = "id",
                    heartQuantity = 5,
                    tags = listOf(TagModel("sdf","sdf",null)),
                    comments = listOf(CommentModel("sdf", listOf("sdf", "sdf"),null, UserModel("sdf","sdf","sdf"))),
                    location = LocationModel(1.1, 1.1),
                    category = CategoryModel("id", "label"),
                    owner = null,
                    verified = true,
                    hearted = false
                ),
                PlaceModel(
                    name = "달달",
                    id = "id",
                    heartQuantity = 5,
                    tags = listOf(TagModel("sdf","sdf",null)),
                    comments = listOf(CommentModel("sdf", listOf("sdf", "sdf"),null, UserModel("sdf","sdf","sdf"))),
                    location = LocationModel(1.1, 1.1),
                    category = CategoryModel("id", "label"),
                    owner = null,
                    verified = true,
                    hearted = false
                )
            )
        }

        binding.nicheAdLayout.setOnClickListener {
            startActivity(Intent(context, EditStoreInfoActivity::class.java))
        }

        return binding.root
    }
}