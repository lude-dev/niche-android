package com.implude.niche.presentation.main.user

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.implude.niche.R
import com.implude.niche.databinding.FragmentUserBinding
import com.implude.niche.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFragment : BaseFragment<FragmentUserBinding>(R.layout.fragment_user) {

    private val userViewModel: UserViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding.heartMoreTextview.setOnClickListener {
            startActivity(Intent(context, MyHeartsActivity::class.java))
        }

        binding.recentCommentMoreTextview.setOnClickListener {
            startActivity(Intent(context, MyCommentsActivity::class.java))
        }

        return binding.root
    }
}