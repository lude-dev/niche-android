package com.implude.niche.domain.repositories

import com.implude.niche.domain.models.LocationModel

interface LocalRepository {
    fun getCurrentLocation(): LocationModel
}