package com.zobaer53.starwars.app.planet.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.zobaer53.starwars.app.character.presentation.CharacterViewModel
import com.zobaer53.starwars.app.planet.domain.entity.Planet
import com.zobaer53.starwars.app.planet.presentation.componet.PlanetItem
import com.zobaer53.starwars.app.util.ErrorMessage
import com.zobaer53.starwars.app.util.LoadingNextPageItem
import com.zobaer53.starwars.app.util.PageLoader
import com.zobaer53.starwars.app.util.route.AppScreen

@Composable
fun PlanetsScreen(
    navController: NavController,
    viewModel: PlanetViewModel = hiltViewModel(navController.getBackStackEntry(AppScreen.MainScreen.route))
) {
    val planetPagingItems: LazyPagingItems<Planet> =
        viewModel.planetsState.collectAsLazyPagingItems()
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        item { Spacer(modifier = Modifier.padding(4.dp)) }

        items(planetPagingItems.itemCount) { index ->
            val planet = planetPagingItems[index]!!

            PlanetItem(
                planet = planet,
                onClick = {
                    navController.navigate("${AppScreen.PlanetDetailsScreen.route}/${planet.id}",
                        builder = {
                            // Pop up to the CharacterScreen route, excluding it from the back stack
                            popUpTo(AppScreen.MainScreen.route) {
                                inclusive = false
                            }
                        })
                }
            )
        }

        planetPagingItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { PageLoader(modifier = Modifier.fillParentMaxSize()) }
                }

                loadState.refresh is LoadState.Error -> {
                    val error = planetPagingItems.loadState.refresh as LoadState.Error
                    item {
                        ErrorMessage(
                            modifier = Modifier.fillParentMaxSize(),
                            message = error.error.localizedMessage!!,
                            onClickRetry = { retry() })
                    }
                }

                loadState.append is LoadState.Loading -> {
                    item { LoadingNextPageItem(modifier = Modifier) }
                }

                loadState.append is LoadState.Error -> {
                    val error = planetPagingItems.loadState.append as LoadState.Error
                    item {
                        ErrorMessage(
                            modifier = Modifier,
                            message = error.error.localizedMessage!!,
                            onClickRetry = { retry() })
                    }
                }
            }
        }
        item { Spacer(modifier = Modifier.padding(4.dp)) }
    }
}

@Composable
@Preview
fun PlanetsScreenPreview() {

    // Mock a NavController
    val navController: NavController = rememberNavController()

    // Mock a ViewModel using hiltViewModel
    val viewModel = hiltViewModel<PlanetViewModel>()

    // Mock planet data for preview
    val planet = Planet(
        id = "1",
        name = "Tatooine",
        climate = "Arid",
        created = "2023-11-14T09:00:00Z",
        diameter = "10465",
        gravity = "1 standard",
        orbitalPeriod = "op",
        population = "population",
        rotationPeriod = "rp",
        surfaceWater = "sw", terrain = "t"
    )

    // Preview the PlanetsScreen
    PlanetsScreen(
        navController =navController, /* Mock NavController */
        viewModel =viewModel, /* Mock ViewModel */
    )
}
