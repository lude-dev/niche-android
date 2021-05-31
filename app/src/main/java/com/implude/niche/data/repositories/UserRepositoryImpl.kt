package com.implude.niche.data.repositories

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.rx3.rxMutate
import com.implude.niche.LoginMutation
import com.implude.niche.data.mappers.Mapper
import com.implude.niche.data.operationFailedException
import com.implude.niche.data.safeSingleCall
import com.implude.niche.domain.models.RegisteredInfoModel
import com.implude.niche.domain.models.TokenInfoModel
import com.implude.niche.domain.repositories.UserRepository
import io.reactivex.rxjava3.core.Single

class UserRepositoryImpl(
    private val apolloClient: ApolloClient,
    private val tokenInfoMapper: Mapper<LoginMutation.Data, TokenInfoModel>,
) : UserRepository {
    override fun login(email: String, password: String): Single<TokenInfoModel> = safeSingleCall {
        apolloClient.rxMutate(LoginMutation(email, password))
            .blockingGet()
            .data
            ?.let(tokenInfoMapper::map)
            ?: throw operationFailedException
    }

    override fun registerUser(
        email: String,
        password: String,
        name: String,
        profileImage: String
    ): Single<RegisteredInfoModel> {
        TODO("Not yet implemented")
    }
}