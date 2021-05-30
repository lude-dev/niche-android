package com.implude.niche.domain.models

data class CategoryModel(
    override val id: String,
    val label: String,
) : DocumentModel
