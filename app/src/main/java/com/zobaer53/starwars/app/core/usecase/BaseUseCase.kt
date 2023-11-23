package com.zobaer53.starwars.app.core.usecase

interface BaseUseCase<In, Out> {
    suspend fun execute(input: In): Out
}