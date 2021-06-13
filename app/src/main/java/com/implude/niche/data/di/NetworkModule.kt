package com.implude.niche.data.di

import com.apollographql.apollo.ApolloClient
import com.implude.niche.data.mappers.CreatedPlaceMapper
import com.implude.niche.data.mappers.NearPlacesMapper
import com.implude.niche.data.mappers.RegisteredInfoMapper
import com.implude.niche.data.mappers.TokenInfoMapper
import com.implude.niche.data.repositories.ParticipationRepositoryImpl
import com.implude.niche.data.repositories.PlaceRepositoryImpl
import com.implude.niche.data.repositories.UserRepositoryImpl
import com.implude.niche.domain.repositories.ParticipationRepository
import com.implude.niche.domain.repositories.PlaceRepository
import com.implude.niche.domain.repositories.UserRepository
import org.koin.dsl.module

val networkModule = module {
    single {
        ApolloClient.builder()
            .serverUrl("https://niche-backend-ssrfsfwh3a-uc.a.run.app/")
            .build()
    }

    single { CreatedPlaceMapper() }
    single { NearPlacesMapper() }
    single { RegisteredInfoMapper() }
    single { TokenInfoMapper() }

    single<PlaceRepository> { PlaceRepositoryImpl(get(), get(), get()) }
    single<UserRepository> { UserRepositoryImpl(get(), get(), get()) }
    single<ParticipationRepository> { ParticipationRepositoryImpl(get(), get()) }
}
