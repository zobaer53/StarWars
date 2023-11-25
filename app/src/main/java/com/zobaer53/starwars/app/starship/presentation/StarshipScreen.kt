package com.zobaer53.starwars.app.starship.presentation

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
import com.zobaer53.starwars.app.starship.domain.entity.Starship
import com.zobaer53.starwars.app.starship.presentation.component.StarshipItem
import com.zobaer53.starwars.app.util.ErrorMessage
import com.zobaer53.starwars.app.util.LoadingNextPageItem
import com.zobaer53.starwars.app.util.PageLoader
import com.zobaer53.starwars.app.util.route.AppScreen

@Composable
fun StarshipScreen(
    navController: NavController,
    viewModel: StarshipViewModel= hiltViewModel(navController.getBackStackEntry(AppScreen.MainScreen.route))
){
    val starshipPagingItems : LazyPagingItems<Starship> = viewModel.starshipsState.collectAsLazyPagingItems()
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        item { Spacer(modifier = Modifier.padding(4.dp)) }

        items(starshipPagingItems.itemCount) { index ->

            val starship =starshipPagingItems[index]!!

            StarshipItem(
               starship = starship
            ) {
                navController.navigate("${AppScreen.StarshipDetailsScreen.route}/${starship.id}",
                    builder = {
                        // Pop up to the CharacterScreen route, excluding it from the back stack
                        popUpTo(AppScreen.MainScreen.route) {
                            inclusive = false
                        }
                    })
            }
        }

        starshipPagingItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { PageLoader(modifier = Modifier.fillParentMaxSize()) }
                }

                loadState.refresh is LoadState.Error -> {
                    val error = starshipPagingItems.loadState.refresh as LoadState.Error
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
                    val error = starshipPagingItems.loadState.append as LoadState.Error
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