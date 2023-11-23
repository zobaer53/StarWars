package com.zobaer53.starwars.app.character.data.datasource.remote

import com.zobaer53.starwars.app.character.data.model.dto.CharacterDto

interface CharacterRemoteDataSource {
    suspend fun getCharacter(page: Int): CharacterDto
}