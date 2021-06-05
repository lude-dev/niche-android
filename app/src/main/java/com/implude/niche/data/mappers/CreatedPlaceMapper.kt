package com.implude.niche.data.mappers

import com.implude.niche.CreatePlaceMutation
import com.implude.niche.domain.models.CategoryModel
import com.implude.niche.domain.models.LocationModel
import com.implude.niche.domain.models.PlaceModel
import com.implude.niche.domain.models.TagModel
import com.implude.niche.domain.models.UserModel

class CreatedPlaceMapper : Mapper<CreatePlaceMutation.Data, PlaceModel> {
    override fun map(data: CreatePlaceMutation.Data): PlaceModel = data.createPlace?.run {
        PlaceModel(
            id = _id,
            name = name,
            location = LocationModel(location.lat ?: Double.NaN, location.lon ?: Double.NaN),
            category = CategoryModel(category._id, category.label ?: ""),
            tags = tags.filterNotNull().map { TagModel(it._id, it.label, null) },
            owner = owner?.let { UserModel(it._id, it.name, it.profileImage ?: "") },
            verified = false,
            comments = listOf(),
            hearted = false,
        )
    } ?: throw mappingFailedException
}
