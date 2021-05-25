package com.implude.niche.presentation.participation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.implude.niche.databinding.FragmentParticipationBinding

class ParticipationFragment : Fragment() {

    private lateinit var participationViewModel: ParticipationViewModel
    private var _binding: FragmentParticipationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        participationViewModel =
            ViewModelProvider(this).get(ParticipationViewModel::class.java)

        _binding = FragmentParticipationBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}