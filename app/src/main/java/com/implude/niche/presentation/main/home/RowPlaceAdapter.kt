package com.implude.niche.presentation.main.home

import android.content.Context
import com.implude.niche.R
import com.implude.niche.databinding.RowRecyclerItemBinding
import com.implude.niche.domain.models.LocationModel
import com.implude.niche.domain.models.ReducedPlaceModel
import com.implude.niche.presentation.base.BaseRecyclerViewAdapter

class RowPlaceAdapter(context: Context) : BaseRecyclerViewAdapter<ReducedPlaceModel, RowRecyclerItemBinding>(
    context,
    R.layout.row_recycler_item,
    { binding, item ->
        binding.reducedPlace = item
    }
) {

    private val viewHolders: MutableList<ViewHolderImpl> = mutableListOf()
    var location: LocationModel? = null
        set(value) {
            if (value != null) {
                field = value
                viewHolders.forEach { it.binding.invalidateAll() }
            }
        }

    override fun onBindViewHolder(holder: ViewHolderImpl, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binding.userLocation = location
        viewHolders.add(holder)
    }
}
