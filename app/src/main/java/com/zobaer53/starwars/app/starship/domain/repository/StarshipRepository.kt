package com.zobaer53.starwars.app.starship.domain.repository

import androidx.paging.PagingData
import com.zobaer53.starwars.app.starship.domain.entity.Starship
import kotlinx.coroutines.flow.Flow

interface StarshipRepository {
    suspend fun getStarships(): Flow<PagingData<Starship>>
}