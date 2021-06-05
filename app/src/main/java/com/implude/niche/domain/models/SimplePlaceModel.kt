package com.implude.niche.domain.models

data class ReducedPlaceModel(
    override val id: String,
    val category: CategoryModel,
    val commentQuantity: Int,
    val heartQuantity: Int,
    val hearted: Boolean,
    val location: LocationModel,
    val name: String,
    val tags: List<TagModel>,
    val verified: Boolean,
) : DocumentModel
