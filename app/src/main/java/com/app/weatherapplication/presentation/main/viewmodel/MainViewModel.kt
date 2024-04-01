package com.app.weatherapplication.presentation.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.weatherapplication.core.base.BaseViewModel
import com.app.weatherapplication.core.utils.Result
import com.app.weatherapplication.domain.model.WeatherModel
import com.app.weatherapplication.domain.useCase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: WeatherUseCase) : BaseViewModel() {

    private val _weatherData: MutableLiveData<WeatherModel> = MutableLiveData()
    val weatherData: LiveData<WeatherModel> get() = _weatherData

    fun getWeatherData(city: String) {
        viewModelScope.launch {
            useCase.getWeather(city).collect { resource ->
                when (resource) {
                    is Result.Success -> {
                        _weatherData.value = resource.data
                    }

                    else -> handleResult(resource)
                }
            }
        }
    }

}