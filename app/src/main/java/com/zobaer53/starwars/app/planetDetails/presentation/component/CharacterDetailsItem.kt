package com.zobaer53.starwars.app.planetDetails.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zobaer53.starwars.app.character.domain.entity.Character
import com.zobaer53.starwars.app.planet.domain.entity.Planet

@Composable
fun PlanetDetailsItem(
    planet: Planet?,
    characterId: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = characterId,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodySmall
            )
/*            character?.name?.let {
                CharacterDetailItem("Name", it)
            }
            character?.gender?.let {
                CharacterDetailItem("Gender", it)
            }
            character?.birthYear?.let {
                CharacterDetailItem("Birth Year", it)
            }
            character?.eyeColor?.let {
                CharacterDetailItem("Eye Color", it)
            }
            character?.hairColor?.let {
                CharacterDetailItem("Hair Color", it)
            }
            character?.height?.let {
                CharacterDetailItem("Height", it)
            }
            character?.skinColor?.let {
                CharacterDetailItem("Skin Color", it)
            }*/
        }
    }
}

@Composable
fun CharacterDetailItem(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodySmall
        )
    }
}