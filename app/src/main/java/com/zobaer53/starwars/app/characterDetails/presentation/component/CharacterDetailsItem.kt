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
import androidx.compose.ui.tooling.preview.Preview


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
               CharacterDetailItem(
                    "Name",
                    it
                )
            }
            character?.gender?.let {
                CharacterDetailItem(
                    "Gender",
                    it
                )
            }
            character?.birthYear?.let {
              CharacterDetailItem(
                    "Birth Year",
                    it
                )
            }
            character?.eyeColor?.let {
            CharacterDetailItem(
                    "Eye Color",
                    it
                )
            }
            character?.hairColor?.let {
               CharacterDetailItem(
                    "Hair Color",
                    it
                )
            }
            character?.height?.let {
                CharacterDetailItem(
                    "Height",
                    it
                )
            }
            character?.skinColor?.let {
               CharacterDetailItem(
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

@Composable
@Preview
fun CharacterDetailsItemPreview() {
    // Mock character data for preview
    val character = Character(
        id = "1",
        name = "Luke Skywalker",
        gender = "Male",
        birthYear = "19 BBY",
        eyeColor = "Blue",
        hairColor = "Blond",
        height = "172 cm",
        skinColor = "Fair"
        // Add more properties as needed
    )

    // Mock characterId for preview
    val characterId = "Character ID: 1"

    // Preview the CharacterDetailsItem
    CharacterDetailsItem(character = character, characterId = characterId)
}

@Composable
@Preview
fun CharacterDetailItemPreview() {
    // Mock label and value for preview
    val label = "Name"
    val value = "Luke Skywalker"

    // Preview the CharacterDetailItem
    CharacterDetailItem(label = label, value = value)
}



