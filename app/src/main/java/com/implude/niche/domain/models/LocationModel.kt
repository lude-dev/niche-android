package com.implude.niche.domain.models

import android.location.Location

data class LocationModel(
    val latitude: Double,
    val longitude: Double,
)

fun Location.toLocationModel() = LocationModel(this.latitude, this.longitude)
