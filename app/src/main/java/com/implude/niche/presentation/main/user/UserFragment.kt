package com.implude.niche.presentation.main.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.implude.niche.R
import com.implude.niche.databinding.FragmentUserBinding
import com.implude.niche.presentation.base.BaseFragment

class UserFragment : BaseFragment<FragmentUserBinding>(R.layout.fragment_user) {

    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        userViewModel =
            ViewModelProvider(this).get(UserViewModel::class.java)

        return binding.root
    }
}