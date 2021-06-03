package com.implude.niche.data.mappers

import com.implude.niche.NearPlacesQuery
import com.implude.niche.domain.models.CategoryModel
import com.implude.niche.domain.models.LocationModel
import com.implude.niche.domain.models.PlaceModel
import com.implude.niche.domain.models.TagModel

class NearPlacesMapper : Mapper<NearPlacesQuery.Data, List<PlaceModel>> {
    override fun map(data: NearPlacesQuery.Data): List<PlaceModel> = data.nearPlaces?.filterNotNull()?.map {
        PlaceModel(
            id = it._id,
            name = it.name,
            location = LocationModel(it.location.lat ?: Double.NaN, it.location.lon ?: Double.NaN),
            category = CategoryModel(it.category._id, it.category.label ?: ""),
            tags = it.tags.filterNotNull().map { tag -> TagModel(tag._id, tag.label, null) },
            owner = null,
            verified = it.verified,
            comments = listOf(),
            hearted = it.hearted,
        )
    } ?: throw mappingFailedException
}
