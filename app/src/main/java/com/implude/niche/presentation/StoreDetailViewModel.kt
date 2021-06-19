package com.implude.niche.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.implude.niche.PlaceByIdQuery
import com.implude.niche.domain.repositories.PlaceRepository

class StoreDetailViewModel(
    private val placeRepository: PlaceRepository,
) : ViewModel() {

    private val _place = MutableLiveData<PlaceByIdQuery.Data>()
    val place: LiveData<PlaceByIdQuery.Data> = _place

    fun fetchPlaceById(id: String) {
        placeRepository.placeById(id).subscribe(
            { _place.value = it },
            { }
        )
    }
}