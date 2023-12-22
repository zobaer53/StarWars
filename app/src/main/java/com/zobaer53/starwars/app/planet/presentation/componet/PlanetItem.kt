package com.zobaer53.starwars.app.planet.presentation.componet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zobaer53.starwars.app.planet.domain.entity.Planet

@Composable
fun PlanetItem(planet: Planet, onClick: () -> Unit){
    Box(modifier = Modifier.padding(top = 8.dp)) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column {
                Text(
                    text = planet.name!!,
                    modifier = Modifier
                        .clickable {
                            onClick.invoke()
                        }
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}
@Composable
@Preview
fun PlanetItemPreview() {
    val planet = Planet(name = "demo", climate = "climet", created = "created", diameter = "diameter", gravity = "gravity", orbitalPeriod = "op", population = "population", rotationPeriod = "rp", surfaceWater = "sw", terrain = "t")
    PlanetItem(planet, onClick = {})
}
