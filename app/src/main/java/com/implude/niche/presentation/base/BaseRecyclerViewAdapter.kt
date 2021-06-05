package com.implude.niche.presentation.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T, B : ViewDataBinding>(
    private val context: Context,
    @LayoutRes private val itemLayoutId: Int,
    private val onBind: (B, T) -> Unit,
) : RecyclerView.Adapter<BaseRecyclerViewAdapter<T, B>.ViewHolderImpl>() {

    var items = listOf<T>()
        set(value) {
            field = value
            notifyItemRangeChanged(0, value.size)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderImpl {
        return DataBindingUtil.inflate<B>(
            LayoutInflater.from(context), itemLayoutId, parent, false
        ).let { ViewHolderImpl(it, onBind) }
    }

    override fun onBindViewHolder(holder: ViewHolderImpl, position: Int) {
        holder.onBind(holder.binding, items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolderImpl(
        val binding: B,
        val onBind: (B, T) -> Unit
    ) : RecyclerView.ViewHolder(binding.root)
}
