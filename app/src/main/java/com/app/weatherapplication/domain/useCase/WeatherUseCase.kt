package com.app.weatherapplication.domain.useCase

import com.app.weatherapplication.core.utils.Result
import com.app.weatherapplication.data.repository.Repository
import com.app.weatherapplication.domain.mapper.WeatherMapper
import com.app.weatherapplication.domain.model.WeatherModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val repository: Repository,
    private val mapper: WeatherMapper
) {

    suspend fun getWeather(city: String): Flow<Result<WeatherModel>> {
        return repository.getWeatherData(city).map { res ->
            when (res) {
                is Result.Loading -> Result.Loading
                is Result.Error -> Result.Error(res.message, res.throwable)
                is Result.Success -> Result.Success(
                    mapper.mapFrom(res.data)
                )
            }
        }
    }
}