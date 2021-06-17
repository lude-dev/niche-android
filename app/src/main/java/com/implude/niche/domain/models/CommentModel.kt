package com.implude.niche.domain.models

data class CommentModel(
    val content: String,
    val photo: String,
    val place: PlaceModel?,
    val user: UserModel,
)
