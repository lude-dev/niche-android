package com.implude.niche.data.mappers

import com.implude.niche.NearFixReportQuery
import com.implude.niche.domain.models.CategoryModel
import com.implude.niche.domain.models.LocationModel
import com.implude.niche.domain.models.NeedFixReportModel
import com.implude.niche.domain.models.PlaceModel
import com.implude.niche.domain.models.TagModel
import com.implude.niche.domain.models.UserModel

class NearFixReportsMapper : Mapper<NearFixReportQuery.Data, List<NeedFixReportModel>> {
    override fun map(data: NearFixReportQuery.Data): List<NeedFixReportModel> = data.nearFixReport?.filterNotNull()
        ?.map {
            val place = it.place
            NeedFixReportModel(
                PlaceModel(
                    id = place._id,
                    category = CategoryModel(place.category._id, place.category.label ?: ""),
                    comments = listOf(),
                    heartQuantity = place.heartQuantity,
                    hearted = place.hearted ?: false,
                    location = LocationModel(place.location.lat ?: Double.NaN, place.location.lon ?: Double.NaN),
                    name = place.name,
                    owner = place.owner?.let { owner -> UserModel(owner._id, owner.name, owner.profileImage) },
                    tags = place.tags.filterNotNull().map { tag -> TagModel(tag._id, tag.label, listOf()) },
                    verified = place.verified,
                ),
                it.value ?: "",
            )
        } ?: throw mappingFailedException
}