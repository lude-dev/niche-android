package com.implude.niche.presentation.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.implude.niche.databinding.RowRecyclerItemBinding
import com.implude.niche.domain.model.Place

class PlaceAdapter(private val context: Context) :
    RecyclerView.Adapter<PlaceAdapter.BaseViewHolder>() {

    var data = listOf<Place>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = RowRecyclerItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )

        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class BaseViewHolder(val item: RowRecyclerItemBinding) : RecyclerView.ViewHolder(item.root) {
        fun onBind(data: Place) {
            item.place = data
        }
    }
}