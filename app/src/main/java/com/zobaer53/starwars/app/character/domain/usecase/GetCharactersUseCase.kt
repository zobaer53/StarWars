package com.zobaer53.starwars.app.character.domain.usecase

import androidx.paging.PagingData
import com.zobaer53.starwars.app.character.domain.entity.Character
import com.zobaer53.starwars.app.character.domain.repository.CharacterRepository
import com.zobaer53.starwars.app.core.usecase.BaseUseCase

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) : BaseUseCase<Unit, Flow<PagingData<Character>>> {
    override suspend fun execute(input: Unit): Flow<PagingData<Character>> {
        return repository.getCharacters()
    }
}