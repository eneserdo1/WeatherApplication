package com.app.weatherapplication.domain.model

import com.app.weatherapplication.data.model.CurrentCondition
import com.app.weatherapplication.data.model.Weather

data class WeatherModel(
    val city: String,
    val currentCondition: CurrentCondition,
    val weatherForecast: List<Weather>
)