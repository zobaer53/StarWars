package com.zobaer53.starwars.app.characterDetails.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zobaer53.starwars.app.character.domain.entity.Character


@Composable
fun CharacterDetailsItem(
    character: Character?, characterId: String
) {
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
