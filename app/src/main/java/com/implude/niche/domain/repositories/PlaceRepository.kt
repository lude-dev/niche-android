package com.implude.niche.domain.repositories

import com.implude.niche.domain.models.PlaceModel
import com.implude.niche.domain.models.ReducedPlaceModel
import io.reactivex.rxjava3.core.Single

interface PlaceRepository {
    fun createPlace(
        name: String,
        latitude: Double,
        longitude: Double,
        category: String,
        tags: List<String>
    ): Single<PlaceModel>

    fun nearPlace(latitude: Double, longitude: Double): Single<List<ReducedPlaceModel>>
}
