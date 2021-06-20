package com.implude.niche.presentation

import androidx.lifecycle.ViewModel
import com.implude.niche.data.LocalDataStore
import com.implude.niche.domain.repositories.PlaceRepository

class StoreAddViewModel(
    private val placeRepository: PlaceRepository,
    private val localDataStore: LocalDataStore,
) : ViewModel(){

    var name = ""
    var category = ""

    fun addStore() {
        val (lat, lon) = localDataStore.location ?: return
        placeRepository.createPlace(
            name, lat, lon, category, listOf()
        ).subscribe({}, {})
    }

    fun fetchStore(id: String) {
        placeRepository.placeById(id).subscribe(
            {
                name = it.place?.name ?: ""
                category = it.place?.category?.label ?: ""
            },
            { }
        )
    }
}