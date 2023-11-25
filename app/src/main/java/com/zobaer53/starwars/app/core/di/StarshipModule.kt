package com.zobaer53.starwars.app.core.di

import com.zobaer53.starwars.app.core.db.StarWarsDatabase
import com.zobaer53.starwars.app.core.network.StarWarsApi
import com.zobaer53.starwars.app.starship.data.datasource.remote.StarshipRemoteDataSource
import com.zobaer53.starwars.app.starship.data.datasource.remote.StarshipRemoteDataSourceImpl
import com.zobaer53.starwars.app.starship.data.repository.StarshipRepositoryImpl
import com.zobaer53.starwars.app.starship.domain.repository.StarshipRepository
import com.zobaer53.starwars.app.starship.domain.usecase.GetStarshipUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StarshipModule {

    @Singleton
    @Provides
    fun providesStarshipRemoteDataSource(
        api: StarWarsApi
    ): StarshipRemoteDataSource {
        return StarshipRemoteDataSourceImpl(api)
    }

    @Singleton
    @Provides
    fun providesStarshipRepository(
        starshipRemoteDataSource: StarshipRemoteDataSource,
        starWarsDatabase: StarWarsDatabase
    ): StarshipRepository {
        return StarshipRepositoryImpl(starshipRemoteDataSource, starWarsDatabase)
    }

    @Singleton
    @Provides
    fun providesGetStarshipsUseCase(
        starshipRepository: StarshipRepository
    ): GetStarshipUseCase {
        return GetStarshipUseCase(starshipRepository)
    }

}
