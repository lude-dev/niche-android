package com.implude.niche.presentation.main.participation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.implude.niche.R
import com.implude.niche.databinding.FragmentParticipationBinding
import com.implude.niche.presentation.base.BaseFragment

class ParticipationFragment : BaseFragment<FragmentParticipationBinding>(R.layout.fragment_participation) {

    private lateinit var participationViewModel: ParticipationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        participationViewModel =
            ViewModelProvider(this).get(ParticipationViewModel::class.java)

        return binding.root
    }
}