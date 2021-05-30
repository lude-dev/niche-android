package com.implude.niche.domain.repositories

import com.implude.niche.domain.models.RegisteredInfoModel
import com.implude.niche.domain.models.TokenInfoModel
import io.reactivex.rxjava3.core.Single

interface UserRepository {
    fun login(email: String, password: String): Single<TokenInfoModel>

    fun registerUser(
        email: String,
        password: String,
        name: String,
        profileImage: String
    ): Single<RegisteredInfoModel>
}