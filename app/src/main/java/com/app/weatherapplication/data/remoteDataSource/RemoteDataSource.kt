package com.app.weatherapplication.data.remoteDataSource

import com.app.weatherapplication.data.model.WeatherResponse
import com.app.weatherapplication.core.utils.Result
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getWeatherData(city: String): Flow<Result<WeatherResponse>>
}