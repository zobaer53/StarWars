package com.zobaer53.starwars.app.starship.data.datasource.remote

import com.zobaer53.starwars.app.starship.data.model.dto.StarshipDto
import com.zobaer53.starwars.app.core.network.StarWarsApi
import javax.inject.Inject

class StarshipRemoteDataSourceImpl @Inject constructor(
    private val api: StarWarsApi
) : StarshipRemoteDataSource {
    override suspend fun getStarship(page: Int): StarshipDto {
        return api.getStarship(page)
    }
}