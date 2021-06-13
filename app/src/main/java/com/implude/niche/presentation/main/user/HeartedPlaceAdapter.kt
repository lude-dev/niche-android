package com.implude.niche.presentation.main.user

import android.content.Context
import com.implude.niche.R
import com.implude.niche.databinding.ItemPlaceLikedBinding
import com.implude.niche.domain.models.PlaceModel
import com.implude.niche.presentation.base.BaseRecyclerViewAdapter

class HeartedPlaceAdapter(context: Context) : BaseRecyclerViewAdapter<PlaceModel, ItemPlaceLikedBinding>(
    context,
    R.layout.item_place_liked,
    { binding, item ->
        binding.place = item
    }
)
