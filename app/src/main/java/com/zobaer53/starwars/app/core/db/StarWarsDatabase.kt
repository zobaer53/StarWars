package com.zobaer53.starwars.app.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zobaer53.starwars.app.character.data.datasource.local.CharacterDao
import com.zobaer53.starwars.app.character.data.datasource.local.CharacterRemoteKeys
import com.zobaer53.starwars.app.character.data.datasource.local.CharacterRemoteKeysDao
import com.zobaer53.starwars.app.character.domain.entity.Character
import com.zobaer53.starwars.app.planet.data.datasource.local.PlanetDao
import com.zobaer53.starwars.app.planet.data.datasource.local.PlanetRemoteKeys
import com.zobaer53.starwars.app.planet.data.datasource.local.PlanetRemoteKeysDao
import com.zobaer53.starwars.app.planet.domain.entity.Planet
import com.zobaer53.starwars.app.starship.data.datasource.local.StarshipDao
import com.zobaer53.starwars.app.starship.data.datasource.local.StarshipRemoteKeys
import com.zobaer53.starwars.app.starship.data.datasource.local.StarshipRemoteKeysDao
import com.zobaer53.starwars.app.starship.domain.entity.Starship


@Database(
    entities = [
        Character::class,
        CharacterRemoteKeys::class,
        Planet::class,
        PlanetRemoteKeys::class,
        Starship::class,
        StarshipRemoteKeys::class],
    version = 1,
    exportSchema = false
)
abstract class StarWarsDatabase: RoomDatabase() {

    abstract fun characterDao(): CharacterDao
    abstract fun characterRemoteKeysDao(): CharacterRemoteKeysDao
    abstract fun starshipDao(): StarshipDao
    abstract fun starshipRemoteKeysDao(): StarshipRemoteKeysDao

    abstract fun planetDao(): PlanetDao
    abstract fun planetRemoteKeysDao(): PlanetRemoteKeysDao

    companion object{
        const val DATABASE_NAME = "star_wars_db"
    }
}