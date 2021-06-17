package com.implude.niche.presentation.di

import android.content.Context
import android.location.LocationManager
import com.implude.niche.data.LocalDataStore
import com.implude.niche.data.repositories.LocalRepositoryImpl
import com.implude.niche.domain.repositories.LocalRepository
import com.implude.niche.presentation.StoreDetailViewModel
import com.implude.niche.presentation.main.home.HomeViewModel
import com.implude.niche.presentation.main.participation.ParticipationViewModel
import com.implude.niche.presentation.main.user.UserViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get(), get(), get()) }
    viewModel { ParticipationViewModel(get(), get()) }
    viewModel { UserViewModel() }
    viewModel { StoreDetailViewModel(get()) }

    single { LocalDataStore() }

    single { androidContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager }
    single<LocalRepository> { LocalRepositoryImpl(get()) }
}
