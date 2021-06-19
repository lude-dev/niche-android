package com.implude.niche.presentation.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.implude.niche.data.LocalDataStore
import com.implude.niche.domain.models.ReducedPlaceModel
import com.implude.niche.domain.repositories.LocalRepository
import com.implude.niche.domain.repositories.PlaceRepository
import com.implude.niche.presentation.util.SingleLiveEvent

class HomeViewModel(
    val localDataStore: LocalDataStore,
    private val localRepository: LocalRepository,
    private val placeRepository: PlaceRepository,
) : ViewModel() {

    val locationFetchSuccessEvent = SingleLiveEvent<Unit>()
    val locationFetchFailedEvent = SingleLiveEvent<Unit>()
    val locationPermissionDeniedEvent = SingleLiveEvent<Unit>()
    val nearPlaceFetchFailedEvent = SingleLiveEvent<Unit>()

    private val _nearPlace = MutableLiveData<List<ReducedPlaceModel>>()
    val nearPlace: LiveData<List<ReducedPlaceModel>> = _nearPlace

    fun fetchLocation() {
        localRepository.getCurrentLocation().subscribe(
            {
                localDataStore.location = it
                locationFetchSuccessEvent.call()
            },
            {
                if (it is SecurityException) locationPermissionDeniedEvent.call()
                else locationFetchFailedEvent.call()
            }
        )
    }

    fun fetchNearPlace() {
        val (lat, lon) = localDataStore.location ?: return
        placeRepository.nearPlace(lat, lon).subscribe(
            { _nearPlace.value = it },
            { nearPlaceFetchFailedEvent.call() }
        )
    }

    companion object {
        const val TAG = "HomeViewModel"
    }
}
