package com.implude.niche.data.mappers

import com.implude.niche.RegisterUserMutation
import com.implude.niche.domain.models.RegisteredInfoModel

class RegisteredInfoMapper : Mapper<RegisterUserMutation.Data, RegisteredInfoModel> {
    override fun map(data: RegisterUserMutation.Data): RegisteredInfoModel = data.registerUser?.run {
        RegisteredInfoModel(email = email, accessToken = accessToken)
    } ?: throw mappingFailedException
}
