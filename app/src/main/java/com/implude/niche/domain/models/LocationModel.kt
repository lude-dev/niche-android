package com.implude.niche.domain.models

import android.location.Location
import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.sqrt

data class LocationModel(
    val latitude: Double,
    val longitude: Double,
) {
    fun distanceTo(other: LocationModel): Double {
        val (lat1, lon1) = this
        val (lat2, lon2) = other

        val p = 0.017453292519943295
        val a = 0.5 - cos((lat2 - lat1) * p) / 2 +
                cos(lat1 * p) * cos(lat2 * p) *
                (1 - cos((lon2 - lon1) * p)) / 2

        return 12742000 * asin(sqrt(a))
    }
}

fun Location.toLocationModel() = LocationModel(this.latitude, this.longitude)
