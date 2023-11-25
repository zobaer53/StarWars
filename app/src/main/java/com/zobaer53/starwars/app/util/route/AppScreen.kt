package com.zobaer53.starwars.app.util.route

sealed class AppScreen(val route: String) {
    object MainScreen : AppScreen(ConstantAppScreenName.MAIN_SCREEN)
    object CharacterScreen : AppScreen(ConstantAppScreenName.CHARACTER_SCREEN)
    object PlanetScreen : AppScreen(ConstantAppScreenName.PLANET_SCREEN)
    object StarshipScreen : AppScreen(ConstantAppScreenName.STARSHIP_SCREEN)
    object CharacterDetailsScreen : AppScreen(ConstantAppScreenName.CHARACTER_DETAILS_SCREEN)
    object PlanetDetailsScreen : AppScreen(ConstantAppScreenName.PLANET_DETAILS_SCREEN)
    object StarshipDetailsScreen : AppScreen(ConstantAppScreenName.STARSHIP_DETAILS_SCREEN)
}
object ConstantAppScreenName {
    const val MAIN_SCREEN = "main_screen"
    const val CHARACTER_SCREEN = "character_screen"
    const val PLANET_SCREEN = "planet_screen"
    const val STARSHIP_SCREEN = "starship_screen"
    const val CHARACTER_DETAILS_SCREEN = "character_details_screen"
    const val PLANET_DETAILS_SCREEN = "planet_details_screen"
    const val STARSHIP_DETAILS_SCREEN = "starship_details_screen"
}