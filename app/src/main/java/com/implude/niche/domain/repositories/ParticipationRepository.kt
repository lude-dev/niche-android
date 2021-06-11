package com.implude.niche.domain.repositories

import com.implude.niche.domain.models.NeedFixReportModel
import io.reactivex.rxjava3.core.Single

interface ParticipationRepository {

    fun getNearFixReports(latitude: Double, longitude: Double): Single<List<NeedFixReportModel>>
}