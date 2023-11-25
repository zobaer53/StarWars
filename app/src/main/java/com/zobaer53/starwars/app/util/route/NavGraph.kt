package com.zobaer53.starwars.app.util.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zobaer53.starwars.app.MainScreen
import com.zobaer53.starwars.app.character.presentation.CharacterScreen
import com.zobaer53.starwars.app.characterDetails.CharacterDetailScreen
import com.zobaer53.starwars.app.planetDetails.PlanetDetailScreen
import com.zobaer53.starwars.app.starship.presentation.StarshipScreen
import com.zobaer53.starwars.app.starshipDetails.StarshipDetailScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreen.MainScreen.route,
    ) {
        composable(route = AppScreen.MainScreen.route) {
            MainScreen(
                navController = navController
            )
        }
        composable(route = AppScreen.CharacterScreen.route) {
            CharacterScreen(
                navController = navController
            )
        }
        composable(route = AppScreen.StarshipScreen.route) {
            StarshipScreen(
                navController = navController
            )
        }
        // Detail screen for Character
        composable(
            route = AppScreen.CharacterDetailsScreen.route + "/{characterId}",
            arguments = listOf(navArgument("characterId") { type = NavType.StringType })
        ) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")
            CharacterDetailScreen(
                navController = navController,
                characterId = characterId.orEmpty()
            )
        }

        // Detail screen for Planet
        composable(
            route = AppScreen.PlanetDetailsScreen.route + "/{planetId}",
            arguments = listOf(navArgument("planetId") { type = NavType.StringType })
        ) { backStackEntry ->
            val planetId = backStackEntry.arguments?.getString("planetId")
            PlanetDetailScreen(
                navController = navController,
                planetId = planetId.orEmpty()
            )
        }
        // Detail screen for Starship
        composable(
            route = AppScreen.StarshipDetailsScreen.route + "/{starshipId}",
            arguments = listOf(navArgument("starshipId") { type = NavType.StringType })
        ) { backStackEntry ->
            val starshipId = backStackEntry.arguments?.getString("starshipId")
            StarshipDetailScreen(
                navController = navController,
                starshipId = starshipId.orEmpty()
            )
        }
    }
}
