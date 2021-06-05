package com.implude.niche.domain.models

data class UserModel(
    override val id: String,
    val name: String,
    val profileImage: String?,
) : DocumentModel
