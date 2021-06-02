package com.implude.niche.data.repositories

import android.location.LocationManager
import com.implude.niche.domain.models.LocationModel
import com.implude.niche.domain.models.toLocationModel
import com.implude.niche.domain.repositories.LocalRepository
import io.reactivex.rxjava3.core.Single

class LocalRepositoryImpl(
    private val locationManager: LocationManager,
) : LocalRepository {
    override fun getCurrentLocation(): Single<LocationModel> = Single.create { emitter ->
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f) { location ->
                emitter.onSuccess(location.toLocationModel())
            }
        } catch (se: SecurityException) {
            emitter.onError(se)
        } catch (t: Throwable) {
            emitter.onError(t)
        }
    }
}