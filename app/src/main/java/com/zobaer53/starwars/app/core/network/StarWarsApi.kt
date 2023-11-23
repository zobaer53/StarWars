package com.zobaer53.starwars.app.core.network

import com.zobaer53.starwars.app.character.data.model.dto.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Query

interface StarWarsApi {

    @GET("people/")
    suspend fun getCharacter(@Query("page") page: Int): CharacterDto
}