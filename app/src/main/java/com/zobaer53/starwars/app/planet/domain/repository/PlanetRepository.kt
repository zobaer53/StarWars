package com.zobaer53.starwars.app.planet.domain.repository

import androidx.paging.PagingData
import com.zobaer53.starwars.app.planet.domain.entity.Planet
import kotlinx.coroutines.flow.Flow

interface PlanetRepository {
    suspend fun getPlanets(): Flow<PagingData<Planet>>
}