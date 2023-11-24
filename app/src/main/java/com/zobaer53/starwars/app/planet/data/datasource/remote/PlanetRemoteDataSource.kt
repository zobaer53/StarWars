package com.zobaer53.starwars.app.planet.data.datasource.remote

import com.zobaer53.starwars.app.planet.data.model.dto.PlanetDto

interface PlanetRemoteDataSource {
    suspend fun getPlanet(page: Int): PlanetDto
}