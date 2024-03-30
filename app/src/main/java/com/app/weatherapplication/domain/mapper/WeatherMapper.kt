package com.app.weatherapplication.domain.mapper

import WeatherResponse
import com.app.weatherapplication.core.utils.Mapper
import com.app.weatherapplication.domain.model.WeatherModel
import javax.inject.Inject

class WeatherMapper @Inject constructor() : Mapper<WeatherResponse, WeatherModel> {
    override fun mapFrom(type: WeatherResponse): WeatherModel {
        return WeatherModel(
            city = type.data.request.first().query,
            currentCondition = type.data.currentCondition.first(),
            weatherForecast = type.data.weather
        )
    }
}