package com.app.weatherapplication.data.repository

import com.app.weatherapplication.data.remoteDataSource.RemoteDataSource
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getWeatherData(city: String) = remoteDataSource.getWeatherData(city)
}