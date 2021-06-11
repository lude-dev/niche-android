package com.implude.niche.data.repositories

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.rx3.rxQuery
import com.implude.niche.NearFixReportQuery
import com.implude.niche.data.mappers.NearFixReportsMapper
import com.implude.niche.data.operationFailedException
import com.implude.niche.data.safeSingleCall
import com.implude.niche.domain.models.NeedFixReportModel
import com.implude.niche.domain.repositories.ParticipationRepository
import io.reactivex.rxjava3.core.Single

class ParticipationRepositoryImpl(
    private val apolloClient: ApolloClient,
    private val nearFixReportsMapper: NearFixReportsMapper,
) : ParticipationRepository {

    override fun getNearFixReports(
        latitude: Double,
        longitude: Double,
    ): Single<List<NeedFixReportModel>> = safeSingleCall {
        apolloClient.rxQuery(NearFixReportQuery(latitude, longitude))
            .blockingFirst()
            .data
            ?.let(nearFixReportsMapper::map)
            ?: throw operationFailedException
    }
}