package com.implude.niche.presentation.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.implude.niche.R
import com.implude.niche.databinding.FragmentEmailBinding
import com.implude.niche.presentation.base.BaseFragment

class EmailFragment : BaseFragment<FragmentEmailBinding>(R.layout.fragment_email) {

    private val signInViewModel by activityViewModels<SignInViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding.vm = signInViewModel

        return binding.root
    }
}