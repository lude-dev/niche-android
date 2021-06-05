package com.implude.niche.data.mappers

import com.implude.niche.NearPlacesQuery
import com.implude.niche.domain.models.CategoryModel
import com.implude.niche.domain.models.LocationModel
import com.implude.niche.domain.models.ReducedPlaceModel
import com.implude.niche.domain.models.TagModel

class NearPlacesMapper : Mapper<NearPlacesQuery.Data, List<ReducedPlaceModel>> {
    override fun map(data: NearPlacesQuery.Data): List<ReducedPlaceModel> = data.nearPlaces?.filterNotNull()?.map {
        ReducedPlaceModel(
            id = it._id,
            name = it.name,
            location = LocationModel(it.location.lat ?: Double.NaN, it.location.lon ?: Double.NaN),
            category = CategoryModel(it.category._id, it.category.label ?: ""),
            tags = it.tags.filterNotNull().map { tag -> TagModel(tag._id, tag.label, null) },
            verified = it.verified,
            hearted = it.hearted,
            commentQuantity = it.commentQuantity,
            heartQuantity = it.heartQuantity,
        )
    } ?: throw mappingFailedException
}
