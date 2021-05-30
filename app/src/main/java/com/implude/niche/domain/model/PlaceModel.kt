package com.implude.niche.domain.model

data class Place(
    val id: String,
    val imageUrl: String,
    val name: String,
    val distance: String,
    val heartCount: Int,
    val commentCount: Int,
    val tags: String,

)