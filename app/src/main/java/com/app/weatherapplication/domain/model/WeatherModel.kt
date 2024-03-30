package com.app.weatherapplication.domain.model

import CurrentCondition
import Weather

data class WeatherModel(
    val city: String,
    val currentCondition: CurrentCondition,
    val weatherForecast: List<Weather>
)