package com.implude.niche.domain.repositories

import com.implude.niche.domain.models.LocationModel
import io.reactivex.rxjava3.core.Single

interface LocalRepository {
    fun getCurrentLocation(): Single<LocationModel>
}
