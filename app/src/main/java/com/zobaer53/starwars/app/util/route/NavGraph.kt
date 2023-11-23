package com.zobaer53.starwars.app.util.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zobaer53.starwars.app.MainScreen
import com.zobaer53.starwars.app.character.presentation.CharacterScreen
import com.zobaer53.starwars.app.characterDetails.presentation.CharacterDetailScreen
import com.zobaer53.starwars.app.starship.presentation.StarshipScreen

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
        // Detail screens for Character
        composable(
            route = AppScreen.DetailsScreen.route + "/{characterId}",
            arguments = listOf(navArgument("characterId") { type = NavType.StringType })
        ) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")
            CharacterDetailScreen(
                navController = navController,
                characterId = characterId.orEmpty()
            )
        }
    }
}