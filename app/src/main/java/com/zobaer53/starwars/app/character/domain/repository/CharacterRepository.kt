package com.zobaer53.starwars.app.character.domain.repository

import androidx.paging.PagingData
import com.zobaer53.starwars.app.character.domain.entity.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharacters(): Flow<PagingData<Character>>
}