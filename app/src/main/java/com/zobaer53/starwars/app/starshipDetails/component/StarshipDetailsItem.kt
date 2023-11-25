package com.zobaer53.starwars.app.starshipDetails.component


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zobaer53.starwars.app.starship.domain.entity.Starship

@Composable
fun StarshipDetailsItem(
    starship: Starship?,
    characterId: String
) {
    LazyColumn {
        item {
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
                    starship?.crew?.let {
                        StarshipDetailItem("Crew", it)
                    }
                    starship?.cargoCapacity?.let {
                        StarshipDetailItem("CargoCapacity", it)
                    }
                    starship?.hyperdriveRating?.let {
                        StarshipDetailItem("HyperdriveRating", it)
                    }
                    starship?.length?.let {
                        StarshipDetailItem("Length", it)
                    }
                    starship?.mGLT?.let {
                        StarshipDetailItem("MGLT", it)
                    }
                    starship?.manufacturer?.let {
                        StarshipDetailItem("Manufacturer", it)
                    }
                    starship?.model?.let {
                        StarshipDetailItem("Model", it)
                    }
                    starship?.name?.let {
                        StarshipDetailItem("Name", it)
                    }
                    starship?.passengers?.let {
                        StarshipDetailItem("Passengers", it)
                    }
                    starship?.starshipClass?.let {
                        StarshipDetailItem("StarshipClass", it)
                    }
                }
            }
        }
    }
}

@Composable
fun StarshipDetailItem(label: String, value: String) {
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
