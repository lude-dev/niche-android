package com.implude.niche.domain.models

data class TagModel(
    override val id: String,
    val label: String,
    val places: List<PlaceModel>?,
) : DocumentModel
