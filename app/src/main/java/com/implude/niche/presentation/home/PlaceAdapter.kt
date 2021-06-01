package com.implude.niche.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.implude.niche.databinding.RowRecyclerItemBinding
import com.implude.niche.domain.models.PlaceModel

class PlaceAdapter(private val context: Context) :
    RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    var data = listOf<PlaceModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowRecyclerItemBinding.inflate(
            LayoutInflater.from(context), parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(val item: RowRecyclerItemBinding) : RecyclerView.ViewHolder(item.root) {
        fun onBind(data: PlaceModel) {
            item.place = data
        }
    }
}