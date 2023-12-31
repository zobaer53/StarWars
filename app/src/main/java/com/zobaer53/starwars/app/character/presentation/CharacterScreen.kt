package com.zobaer53.starwars.app.character.presentation

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
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
                    navController.navigate("${AppScreen.CharacterDetailsScreen.route}/${character.id}",
                        builder = {
                            // Pop up to the CharacterScreen route, excluding it from the back stack
                            popUpTo (AppScreen.MainScreen.route) {
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



@Composable
@Preview
fun CharacterScreenPreview() {
    // Mock a NavController
    val navController: NavController = rememberNavController()

    // Mock a ViewModel using hiltViewModel
    val viewModel = hiltViewModel<CharacterViewModel>()

    // Mock some characters for preview
    val characters: List<Character> = listOf(
     Character(name = "Luke Skywalker", birthYear = "1243", eyeColor = "red", gender = "male", hairColor = "brown", height = "78", skinColor = "white"),
     Character(name = "Luke Skywalker", birthYear = "1243", eyeColor = "red", gender = "male", hairColor = "brown", height = "78", skinColor = "white"),
     Character(name = "Luke Skywalker", birthYear = "1243", eyeColor = "red", gender = "male", hairColor = "brown", height = "78", skinColor = "white"),
     Character(name = "Luke Skywalker", birthYear = "1243", eyeColor = "red", gender = "male", hairColor = "brown", height = "78", skinColor = "white"),

        // Add more characters as needed
    )

    // Preview the CharacterScreen
    CharacterScreen(navController = navController, viewModel = viewModel)


}
// You can also preview the CharacterScreen with different themes
@Composable
@Preview
fun CharacterScreenDarkPreview() {
    // Mock a NavController
    val navController: NavController = rememberNavController()

    // Mock a ViewModel using hiltViewModel
    val viewModel = hiltViewModel<CharacterViewModel>()

    CharacterScreen(navController = navController, viewModel = viewModel)
}
