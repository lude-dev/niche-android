package com.implude.niche.data.repositories

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.rx3.rxMutate
import com.apollographql.apollo.rx3.rxQuery
import com.implude.niche.CreatePlaceMutation
import com.implude.niche.NearPlacesQuery
import com.implude.niche.data.mappers.Mapper
import com.implude.niche.data.operationFailedException
import com.implude.niche.data.safeSingleCall
import com.implude.niche.domain.models.PlaceModel
import com.implude.niche.domain.models.ReducedPlaceModel
import com.implude.niche.domain.repositories.PlaceRepository
import com.implude.niche.type.LocationInput
import io.reactivex.rxjava3.core.Single

class PlaceRepositoryImpl(
    private val apolloClient: ApolloClient,
    private val createdPlaceMapper: Mapper<CreatePlaceMutation.Data, PlaceModel>,
    private val nearPlacesMapper: Mapper<NearPlacesQuery.Data, List<ReducedPlaceModel>>,
) : PlaceRepository {
    override fun createPlace(
        name: String,
        latitude: Double,
        longitude: Double,
        category: String,
        tags: List<String>
    ): Single<PlaceModel> = safeSingleCall {
        apolloClient.rxMutate(
            CreatePlaceMutation(
                LocationInput(latitude, longitude),
                name,
                Input.optional(category),
                Input.optional(tags)
            )
        ).blockingGet()
            .data
            ?.let(createdPlaceMapper::map)
            ?: throw operationFailedException
    }

    override fun nearPlace(latitude: Double, longitude: Double): Single<List<ReducedPlaceModel>> = safeSingleCall {
        apolloClient.rxQuery(NearPlacesQuery(latitude, longitude))
            .blockingFirst()
            .data
            ?.let(nearPlacesMapper::map)
            ?: throw operationFailedException
    }
}
