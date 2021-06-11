package com.implude.niche.presentation.main.participation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.implude.niche.R
import com.implude.niche.databinding.FragmentParticipationBinding
import com.implude.niche.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ParticipationFragment : BaseFragment<FragmentParticipationBinding>(R.layout.fragment_participation) {

    private val participationViewModel: ParticipationViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        return binding.root
    }
}