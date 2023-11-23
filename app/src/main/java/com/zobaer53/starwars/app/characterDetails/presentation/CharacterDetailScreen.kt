package com.zobaer53.starwars.app.characterDetails.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.zobaer53.starwars.app.character.domain.entity.Character
import com.zobaer53.starwars.app.character.presentation.CharacterViewModel
import com.zobaer53.starwars.app.util.route.AppScreen


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CharacterDetailScreen(
    navController: NavController,
    characterId: String,
    viewModel: CharacterViewModel = hiltViewModel(navController.getBackStackEntry(AppScreen.MainScreen.route))
) {
    Scaffold(topBar = { TopAppBar(title = { Text(text = "Details Screen") }) }) {

        Box(modifier = Modifier.padding( 16.dp)) {
            val characterPagingItems: LazyPagingItems<Character> =
                viewModel.charactersState.collectAsLazyPagingItems()

            val characterPagingItemsRemembered by remember {
                mutableStateOf(characterPagingItems)
            }
            val selectedCharacter = characterPagingItemsRemembered.itemSnapshotList
                .find {
                    it!!.id == characterId
                }
            selectedCharacter?.let { character ->
                val rememberedCharacter = remember { character }
                Box(modifier = Modifier.padding(top = 50.dp)) {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant,
                        ), modifier = Modifier.fillMaxWidth()
                    ) {
                        Column {
                            Text(
                                text = characterId,
                                modifier = Modifier.padding(16.dp),
                                textAlign = TextAlign.Center,
                            )
                            rememberedCharacter?.name?.let {
                                Text(
                                    text = it,
                                    modifier = Modifier.padding(16.dp),
                                    textAlign = TextAlign.Center,
                                )
                            }
                            rememberedCharacter?.gender?.let {
                                Text(
                                    text = it,
                                    modifier = Modifier.padding(16.dp),
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}
