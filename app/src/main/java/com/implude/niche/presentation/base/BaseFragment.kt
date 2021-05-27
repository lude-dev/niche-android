package com.implude.niche.presentation.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

open class BaseFragment<B : ViewBinding>(@LayoutRes private val layoutId: Int) : Fragment() {

    private var _binding: B? = null

    /**
     * This field is only valid between onCreateView and onDestroyView.
     */
    protected val binding: B
        get() = _binding!!

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        Log.d("BaseFragment", _binding.toString())
        return binding.root
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}