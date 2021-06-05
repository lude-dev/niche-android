package com.implude.niche.domain.models

data class PlaceModel(
    override val id: String,
    val category: CategoryModel,
    val comments: List<CommentModel>,
    val heartQuantity: Int,
    val hearted: Boolean,
    val location: LocationModel,
    val name: String,
    val owner: UserModel?,
    val tags: List<TagModel>,
    val verified: Boolean,
) : DocumentModel
