package com.implude.niche.data.mappers

import com.implude.niche.LoginMutation
import com.implude.niche.domain.models.TokenInfoModel

class TokenInfoMapper : Mapper<LoginMutation.Data, TokenInfoModel> {
    override fun map(data: LoginMutation.Data): TokenInfoModel =
        TokenInfoModel(data.login?.accessToken ?: throw mappingFailedException)
}
