package com.zobaer53.starwars.app.characterDetails.presentation.component

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

@Composable
fun CharacterDetailsItem(
    character: Character?,
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
            character?.name?.let {
                com.zobaer53.starwars.app.planetDetails.presentation.component.CharacterDetailItem(
                    "Name",
                    it
                )
            }
            character?.gender?.let {
                com.zobaer53.starwars.app.planetDetails.presentation.component.CharacterDetailItem(
                    "Gender",
                    it
                )
            }
            character?.birthYear?.let {
                com.zobaer53.starwars.app.planetDetails.presentation.component.CharacterDetailItem(
                    "Birth Year",
                    it
                )
            }
            character?.eyeColor?.let {
                com.zobaer53.starwars.app.planetDetails.presentation.component.CharacterDetailItem(
                    "Eye Color",
                    it
                )
            }
            character?.hairColor?.let {
                com.zobaer53.starwars.app.planetDetails.presentation.component.CharacterDetailItem(
                    "Hair Color",
                    it
                )
            }
            character?.height?.let {
                com.zobaer53.starwars.app.planetDetails.presentation.component.CharacterDetailItem(
                    "Height",
                    it
                )
            }
            character?.skinColor?.let {
                com.zobaer53.starwars.app.planetDetails.presentation.component.CharacterDetailItem(
                    "Skin Color",
                    it
                )
            }
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
