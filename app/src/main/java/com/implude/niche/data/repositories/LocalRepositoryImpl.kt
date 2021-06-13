package com.implude.niche.data.repositories

import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import com.implude.niche.domain.models.LocationModel
import com.implude.niche.domain.models.toLocationModel
import com.implude.niche.domain.repositories.LocalRepository
import io.reactivex.rxjava3.core.Single

class LocalRepositoryImpl(
    private val locationManager: LocationManager,
) : LocalRepository {
    override fun getCurrentLocation(): Single<LocationModel> = Single.create { emitter ->
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, object : LocationListener {
                override fun onLocationChanged(location: Location) {
                    emitter.onSuccess(location.toLocationModel())
                }

                override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
                }
            })
        } catch (se: SecurityException) {
            emitter.onError(se)
        } catch (t: Throwable) {
            emitter.onError(t)
        }
    }
}