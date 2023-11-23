package com.zobaer53.starwars.app.core.di

import com.zobaer53.starwars.app.character.data.datasource.remote.CharacterRemoteDataSource
import com.zobaer53.starwars.app.character.data.datasource.remote.CharacterRemoteDataSourceImpl
import com.zobaer53.starwars.app.character.domain.repository.CharacterRepository
import com.zobaer53.starwars.app.character.domain.usecase.GetCharactersUseCase
import com.zobaer53.starwars.app.core.db.StarWarsDatabase
import com.zobaer53.starwars.app.character.data.repository.CharacterRepositoryImpl
import com.zobaer53.starwars.app.core.network.StarWarsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object CharacterModule {
    @Provides
    @ViewModelScoped
    fun providesCharacterRemoteDataSource(
        api: StarWarsApi
    ): CharacterRemoteDataSource {
        return CharacterRemoteDataSourceImpl(api)
    }

    @Provides
    @ViewModelScoped
    fun providesCharacterRepository(
        characterRemoteDataSource: CharacterRemoteDataSource,
        starWarsDatabase: StarWarsDatabase
    ): CharacterRepository {
        return CharacterRepositoryImpl(characterRemoteDataSource, starWarsDatabase)
    }

    @Provides
    @ViewModelScoped
    fun providesGetCharactersUseCase(
        characterRepository: CharacterRepository
    ): GetCharactersUseCase {
        return GetCharactersUseCase(characterRepository)
    }
}