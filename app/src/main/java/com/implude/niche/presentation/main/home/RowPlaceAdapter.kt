package com.implude.niche.presentation.main.home

import android.content.Context
import com.implude.niche.R
import com.implude.niche.databinding.RowRecyclerItemBinding
import com.implude.niche.domain.models.PlaceModel
import com.implude.niche.domain.models.ReducedPlaceModel
import com.implude.niche.presentation.base.BaseRecyclerViewAdapter

class RowPlaceAdapter(context: Context) :
    BaseRecyclerViewAdapter<ReducedPlaceModel, RowRecyclerItemBinding>(
        context,
        R.layout.row_recycler_item,
        { binding, item ->
            binding.reducedPlace = item
        }
    )
