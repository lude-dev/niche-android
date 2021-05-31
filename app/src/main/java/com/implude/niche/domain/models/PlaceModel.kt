package com.implude.niche.domain.models

data class PlaceModel(
    override val id: String,
    val name: String,
    val location: LocationModel,
    val category: CategoryModel,
    val tags: List<TagModel>,
    val owner: UserModel?,
    val verified: Boolean,
    val comments: List<CommentModel>,
    val hearted: Boolean,
) : DocumentModel
