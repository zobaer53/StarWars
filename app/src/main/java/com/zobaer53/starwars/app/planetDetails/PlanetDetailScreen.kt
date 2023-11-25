package com.zobaer53.starwars.app.planetDetails

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.zobaer53.starwars.app.planet.domain.entity.Planet
import com.zobaer53.starwars.app.planet.presentation.PlanetViewModel
import com.zobaer53.starwars.app.planetDetails.presentation.component.PlanetDetailsItem
import com.zobaer53.starwars.app.util.route.AppScreen


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PlanetDetailScreen(
    navController: NavController,
    planetId: String,
    viewModel: PlanetViewModel = hiltViewModel(navController.getBackStackEntry(AppScreen.MainScreen.route))
) {
    Scaffold(topBar = { TopAppBar(title = { Text(text = "Planet Details", color = Color.White) },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor =MaterialTheme.colorScheme.primary),
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack()} ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription =null, tint = Color.White)
            }
        }) }) {

        Box(modifier = Modifier.padding( 16.dp)) {
            val planetPagingItems: LazyPagingItems<Planet> =
                viewModel.planetsState.collectAsLazyPagingItems()

            val characterPagingItemsRemembered by remember {
                mutableStateOf(planetPagingItems)
            }
            val selectedCharacter = characterPagingItemsRemembered.itemSnapshotList
                .find {
                    it!!.id == planetId
                }
            selectedCharacter?.let { planet ->
                PlanetDetailsItem(planet, planet.id)
            }
        }
    }

}
