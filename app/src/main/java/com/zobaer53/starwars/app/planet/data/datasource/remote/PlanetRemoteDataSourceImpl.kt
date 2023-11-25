package com.zobaer53.starwars.app.planet.data.datasource.remote

import com.zobaer53.starwars.app.core.network.StarWarsApi
import com.zobaer53.starwars.app.planet.data.model.dto.PlanetDto
import javax.inject.Inject

class PlanetRemoteDataSourceImpl @Inject constructor(
    private val api: StarWarsApi
) : PlanetRemoteDataSource {
    override suspend fun getPlanet(page: Int): PlanetDto {
        return  api.getPlanet(page)
    }
}