package com.app.weatherapplication.data.api

import com.app.weatherapplication.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("premium/v1/ weather.ashx")
    suspend fun getCityWeather(
        @Query("q") city: String,
        @Query("key") key: String,
        @Query("num_of_days") numOfDays: String = "5",
        @Query("format") format: String = "json"
    ): Response<WeatherResponse>
}