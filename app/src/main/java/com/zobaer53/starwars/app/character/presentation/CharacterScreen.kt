package com.zobaer53.starwars.app.character.presentation

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
import com.zobaer53.starwars.app.character.domain.entity.Character
import com.zobaer53.starwars.app.character.presentation.component.CharacterItem
import com.zobaer53.starwars.app.util.ErrorMessage
import com.zobaer53.starwars.app.util.LoadingNextPageItem
import com.zobaer53.starwars.app.util.PageLoader
import com.zobaer53.starwars.app.util.route.AppScreen


@Composable
fun CharacterScreen(
    navController: NavController,
    viewModel: CharacterViewModel = hiltViewModel(navController.getBackStackEntry(AppScreen.MainScreen.route))
) {
    val characterPagingItems: LazyPagingItems<Character> = viewModel.charactersState.collectAsLazyPagingItems()

    // Collect character details state
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        item { Spacer(modifier = Modifier.padding(4.dp)) }

        items(characterPagingItems.itemCount) { index ->
            val character = characterPagingItems[index]!!
            CharacterItem(
                character = character,
                onClick = {
                    navController.navigate("${AppScreen.DetailsScreen.route}/${character.id}",
                        builder = {
                            // Pop up to the CharacterScreen route, excluding it from the back stack
                            popUpTo (AppScreen.CharacterScreen.route) {
                                inclusive = false }
                        })
                }
            )
        }

        characterPagingItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { PageLoader(modifier = Modifier.fillParentMaxSize()) }
                }

                loadState.refresh is LoadState.Error -> {
                    val error = characterPagingItems.loadState.refresh as LoadState.Error
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
                    val error = characterPagingItems.loadState.append as LoadState.Error
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
