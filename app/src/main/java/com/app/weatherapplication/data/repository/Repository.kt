package com.app.weatherapplication.data.repository

import androidx.lifecycle.LiveData
import com.app.weatherapplication.data.dao.CityDao
import com.app.weatherapplication.data.entity.City
import com.app.weatherapplication.data.remoteDataSource.RemoteDataSource
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val cityDao: CityDao
) {

    suspend fun getWeatherData(city: String) = remoteDataSource.getWeatherData(city)

    val allCities: LiveData<List<City>> = cityDao.getAllCities()

    suspend fun insert(city: City) {
        cityDao.insert(city)
    }

    suspend fun delete(city: City) {
        cityDao.delete(city)
    }

    suspend fun update(city: City) {
        cityDao.update(city)
    }
}