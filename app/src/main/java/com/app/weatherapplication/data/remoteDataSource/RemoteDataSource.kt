package com.app.weatherapplication.data.remoteDataSource

import WeatherResponse
import com.app.weatherapplication.core.utils.Result
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getWeatherData(city: String): Flow<Result<WeatherResponse>>
}