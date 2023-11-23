package com.zobaer53.starwars.app.characterDetails.presentation

import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CharacterDetailScreen(
    navController: NavController,
    characterId: String,
) {
    Text(text = "CharacterDetailsScreen")

}



