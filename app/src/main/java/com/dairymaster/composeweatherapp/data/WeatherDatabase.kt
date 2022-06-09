package com.dairymaster.composeweatherapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dairymaster.composeweatherapp.model.Favorite
import com.dairymaster.composeweatherapp.model.Unit


@Database(entities = [Favorite::class, Unit::class], version = 1, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}
