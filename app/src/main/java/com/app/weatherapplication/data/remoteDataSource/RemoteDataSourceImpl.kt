package com.app.weatherapplication.data.remoteDataSource

import com.app.weatherapplication.BuildConfig
import com.app.weatherapplication.data.model.WeatherResponse
import com.app.weatherapplication.core.base.BaseRemoteDataSource
import com.app.weatherapplication.core.utils.NetworkHelper
import com.app.weatherapplication.core.utils.Result
import com.app.weatherapplication.data.api.ApiService
import com.app.weatherapplication.di.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService, networkHelper: NetworkHelper,
    dispatcher: DispatcherProvider
) : RemoteDataSource, BaseRemoteDataSource(networkHelper, dispatcher) {
    override suspend fun getWeatherData(city: String): Flow<Result<WeatherResponse>> {
        return baseRequestFlow { apiService.getCityWeather(city = city, key = BuildConfig.API_KEY) }
    }

}