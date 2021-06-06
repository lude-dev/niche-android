package com.implude.niche.presentation.home

import android.content.Context
import com.implude.niche.R
import com.implude.niche.databinding.RowRecyclerItemBinding
import com.implude.niche.domain.models.PlaceModel
import com.implude.niche.presentation.base.BaseRecyclerViewAdapter

class NearPopularTopicPlaceAdapter(context: Context) : BaseRecyclerViewAdapter<PlaceModel, RowRecyclerItemBinding>(
    context,
    R.layout.row_recycler_item,
    { binding, item ->
        binding.place = item
    }
)
