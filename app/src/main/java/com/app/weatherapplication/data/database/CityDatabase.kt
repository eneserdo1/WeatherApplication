package com.app.weatherapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.weatherapplication.data.dao.CityDao
import com.app.weatherapplication.data.entity.City

@Database(entities = [City::class], version = 2, exportSchema = false)
abstract class CityDatabase : RoomDatabase() {

    abstract fun cityDao(): CityDao
}