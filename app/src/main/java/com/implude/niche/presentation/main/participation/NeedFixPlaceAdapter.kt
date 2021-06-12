package com.implude.niche.presentation.main.participation

import android.content.Context
import com.implude.niche.R
import com.implude.niche.databinding.ItemPlaceNeedFixReportBinding
import com.implude.niche.databinding.RowRecyclerItemBinding
import com.implude.niche.domain.models.PlaceModel
import com.implude.niche.presentation.base.BaseRecyclerViewAdapter

class NeedFixPlaceAdapter(context: Context) : BaseRecyclerViewAdapter<PlaceModel, ItemPlaceNeedFixReportBinding>(
    context,
    R.layout.item_place_need_fix_report,
    { binding, item ->
        binding.place = item
    }
)
