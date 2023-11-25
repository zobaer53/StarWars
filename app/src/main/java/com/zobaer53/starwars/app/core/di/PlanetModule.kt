package com.zobaer53.starwars.app.core.di

import com.zobaer53.starwars.app.core.db.StarWarsDatabase
import com.zobaer53.starwars.app.core.network.StarWarsApi
import com.zobaer53.starwars.app.planet.data.datasource.remote.PlanetRemoteDataSource
import com.zobaer53.starwars.app.planet.data.datasource.remote.PlanetRemoteDataSourceImpl
import com.zobaer53.starwars.app.planet.data.repository.PlanetRepositoryImpl
import com.zobaer53.starwars.app.planet.domain.repository.PlanetRepository
import com.zobaer53.starwars.app.planet.domain.usecase.GetPlanetsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PlanetModule {

    @Singleton
    @Provides
    fun providesPlanetRemoteDataSource(
        api : StarWarsApi
    ): PlanetRemoteDataSource{
        return PlanetRemoteDataSourceImpl(api)
    }

    @Singleton
    @Provides
    fun providesPlanetsRepository(
        planetRemoteDataSource : PlanetRemoteDataSource,
        starWarsDatabase: StarWarsDatabase
    ): PlanetRepository {
        return PlanetRepositoryImpl(planetRemoteDataSource, starWarsDatabase)
    }

    @Singleton
    @Provides
    fun providesGetPlanetsUseCase(
        planetRepository: PlanetRepository
    ): GetPlanetsUseCase {
        return GetPlanetsUseCase(planetRepository)
    }
}