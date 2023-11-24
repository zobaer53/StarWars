package com.zobaer53.starwars.app.planet.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
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
){
    val planetPagingItems : LazyPagingItems<Planet> = viewModel.planetsState.collectAsLazyPagingItems()
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        item { Spacer(modifier = Modifier.padding(4.dp)) }

        items(planetPagingItems.itemCount) { index ->
            val planet =planetPagingItems[index]!!

            PlanetItem(
                planet = planet,
                onClick = {
                    navController.navigate("${AppScreen.DetailsScreen.route}/${planet.id}",
                        builder = {
                            // Pop up to the CharacterScreen route, excluding it from the back stack
                            popUpTo (AppScreen.CharacterScreen.route) {
                                inclusive = false }
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