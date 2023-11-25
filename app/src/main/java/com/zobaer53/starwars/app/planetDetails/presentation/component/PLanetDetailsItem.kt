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
            planet?.climate?.let {
                PlanetDetailItem("Climate", it)
            }
            planet?.created?.let {
                PlanetDetailItem("Created", it)
            }
            planet?.diameter?.let {
                PlanetDetailItem("Birth Year", it)
            }
            planet?.gravity?.let {
                PlanetDetailItem("Gravity", it)
            }
            planet?.name?.let {
                PlanetDetailItem("Name", it)
            }
            planet?.orbitalPeriod?.let {
                PlanetDetailItem("OrbitalPeriod", it)
            }
            planet?.population?.let {
                PlanetDetailItem("Population", it)
            }
            planet?.rotationPeriod?.let {
                PlanetDetailItem("RotationPeriod", it)
            }
            planet?.surfaceWater?.let {
                PlanetDetailItem("SurfaceWater", it)
            }
            planet?.terrain?.let {
                PlanetDetailItem("Terrain", it)
            }
        }
    }
}

@Composable
fun PlanetDetailItem(label: String, value: String) {
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
