package com.implude.niche.presentation.main.home

import androidx.lifecycle.ViewModel
import com.implude.niche.data.LocalDataStore
import com.implude.niche.domain.repositories.LocalRepository
import com.implude.niche.domain.repositories.PlaceRepository

class HomeViewModel(
    private val localDataStore: LocalDataStore,
    private val localRepository: LocalRepository,
    private val placeRepository: PlaceRepository,
) : ViewModel() {

class HomeViewModel : ViewModel() {

}
