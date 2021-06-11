package com.implude.niche.presentation.di

import com.implude.niche.presentation.main.home.HomeViewModel
import com.implude.niche.presentation.main.participation.ParticipationViewModel
import com.implude.niche.presentation.main.user.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel() }
    viewModel { ParticipationViewModel() }
    viewModel { UserViewModel() }
}
