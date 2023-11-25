package com.zobaer53.starwars.app.starshipDetails

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.zobaer53.starwars.app.planet.domain.entity.Planet
import com.zobaer53.starwars.app.planet.presentation.PlanetViewModel
import com.zobaer53.starwars.app.planetDetails.presentation.component.PlanetDetailsItem
import com.zobaer53.starwars.app.starship.domain.entity.Starship
import com.zobaer53.starwars.app.starship.presentation.StarshipViewModel
import com.zobaer53.starwars.app.starshipDetails.component.StarshipDetailsItem
import com.zobaer53.starwars.app.util.route.AppScreen


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StarshipDetailScreen(
    navController: NavController,
    starshipId: String,
    viewModel: StarshipViewModel = hiltViewModel(navController.getBackStackEntry(AppScreen.MainScreen.route))
) {
    Scaffold(topBar = { TopAppBar(title = { Text(text = "Details Screen", color = Color.Black) },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor =MaterialTheme.colorScheme.primary)) }) {

        Box(modifier = Modifier.padding( 16.dp)) {
            val startshipPagingItems: LazyPagingItems<Starship> =
                viewModel.starshipsState.collectAsLazyPagingItems()

            val characterPagingItemsRemembered by remember {
                mutableStateOf(startshipPagingItems)
            }
            val selectedCharacter = characterPagingItemsRemembered.itemSnapshotList
                .find {
                    it!!.id == starshipId
                }
            selectedCharacter?.let { startship ->
                StarshipDetailsItem(startship, startship.id)
            }
        }
    }
}
