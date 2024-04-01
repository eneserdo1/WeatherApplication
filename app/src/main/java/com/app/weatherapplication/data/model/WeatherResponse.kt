package com.app.weatherapplication.data.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("data") val data: Data
)

data class Data(
    @SerializedName("ClimateAverages") val climateAverages: List<ClimateAverage>,
    @SerializedName("current_condition") val currentCondition: List<CurrentCondition>,
    @SerializedName("request") val request: List<Request>,
    @SerializedName("weather") val weather: List<Weather>
)

data class ClimateAverage(
    @SerializedName("month") val month: List<Month>
)

data class CurrentCondition(
    @SerializedName("FeelsLikeC") val feelsLikeC: String,
    @SerializedName("FeelsLikeF") val feelsLikeF: String,
    @SerializedName("cloudcover") val cloudcover: String,
    @SerializedName("humidity") val humidity: String,
    @SerializedName("observation_time") val observationTime: String,
    @SerializedName("precipInches") val precipInches: String,
    @SerializedName("precipMM") val precipMM: String,
    @SerializedName("pressure") val pressure: String,
    @SerializedName("pressureInches") val pressureInches: String,
    @SerializedName("temp_C") val tempC: String,
    @SerializedName("temp_F") val tempF: String,
    @SerializedName("uvIndex") val uvIndex: String,
    @SerializedName("visibility") val visibility: String,
    @SerializedName("visibilityMiles") val visibilityMiles: String,
    @SerializedName("weatherCode") val weatherCode: String,
    @SerializedName("weatherDesc") val weatherDesc: List<WeatherDesc>,
    @SerializedName("weatherIconUrl") val weatherIconUrl: List<WeatherIconUrl>,
    @SerializedName("winddir16Point") val winddir16Point: String,
    @SerializedName("winddirDegree") val winddirDegree: String,
    @SerializedName("windspeedKmph") val windspeedKmph: String,
    @SerializedName("windspeedMiles") val windspeedMiles: String
)

data class Request(
    @SerializedName("query") val query: String
)

data class Weather(
    @SerializedName("astronomy") val astronomy: List<Astronomy>,
    @SerializedName("avgtempC") val avgtempC: String,
    @SerializedName("avgtempF") val avgtempF: String,
    @SerializedName("date") val date: String,
    @SerializedName("hourly") val hourly: List<Hourly>,
    @SerializedName("maxtempC") val maxtempC: String,
    @SerializedName("maxtempF") val maxtempF: String,
    @SerializedName("mintempC") val mintempC: String,
    @SerializedName("mintempF") val mintempF: String,
    @SerializedName("sunHour") val sunHour: String,
    @SerializedName("totalSnow_cm") val totalSnowCm: String,
    @SerializedName("uvIndex") val uvIndex: String
)

data class Month(
    @SerializedName("absMaxTemp") val absMaxTemp: String,
    @SerializedName("absMaxTemp_F") val absMaxTempF: String,
    @SerializedName("avgDailyRainfall") val avgDailyRainfall: String,
    @SerializedName("avgMinTemp") val avgMinTemp: String,
    @SerializedName("avgMinTemp_F") val avgMinTempF: String,
    @SerializedName("index") val index: String,
    @SerializedName("name") val name: String
)

data class WeatherDesc(
    @SerializedName("value") val value: String
)

data class WeatherIconUrl(
    @SerializedName("value") val value: String
)

data class Astronomy(
    @SerializedName("moon_illumination") val moonIllumination: String,
    @SerializedName("moon_phase") val moonPhase: String,
    @SerializedName("moonrise") val moonrise: String,
    @SerializedName("moonset") val moonset: String,
    @SerializedName("sunrise") val sunrise: String,
    @SerializedName("sunset") val sunset: String
)

data class Hourly(
    @SerializedName("DewPointC") val dewPointC: String,
    @SerializedName("DewPointF") val dewPointF: String,
    @SerializedName("FeelsLikeC") val feelsLikeC: String,
    @SerializedName("FeelsLikeF") val feelsLikeF: String,
    @SerializedName("HeatIndexC") val heatIndexC: String,
    @SerializedName("HeatIndexF") val heatIndexF: String,
    @SerializedName("WindChillC") val windChillC: String,
    @SerializedName("WindChillF") val windChillF: String,
    @SerializedName("WindGustKmph") val windGustKmph: String,
    @SerializedName("WindGustMiles") val windGustMiles: String,
    @SerializedName("chanceoffog") val chanceOfFog: String,
    @SerializedName("chanceoffrost") val chanceOfFrost: String,
    @SerializedName("chanceofhightemp") val chanceOfHighTemp: String,
    @SerializedName("chanceofovercast") val chanceOfOvercast: String,
    @SerializedName("chanceofrain") val chanceOfRain: String,
    @SerializedName("chanceofremdry") val chanceOfRemdry: String,
    @SerializedName("chanceofsnow") val chanceOfSnow: String,
    @SerializedName("chanceofsunshine") val chanceOfSunshine: String,
    @SerializedName("chanceofthunder") val chanceOfThunder: String,
    @SerializedName("chanceofwindy") val chanceOfWindy: String,
    @SerializedName("cloudcover") val cloudcover: String,
    @SerializedName("diffRad") val diffRad: String,
    @SerializedName("humidity") val humidity: String,
    @SerializedName("precipInches") val precipInches: String,
    @SerializedName("precipMM") val precipMM: String,
    @SerializedName("pressure") val pressure: String,
    @SerializedName("pressureInches") val pressureInches: String,
    @SerializedName("shortRad") val shortRad: String,
    @SerializedName("tempC") val tempC: String,
    @SerializedName("tempF") val tempF: String,
    @SerializedName("time") val time: String,
    @SerializedName("uvIndex") val uvIndex: String,
    @SerializedName("visibility") val visibility: String,
    @SerializedName("visibilityMiles") val visibilityMiles: String,
    @SerializedName("weatherCode") val weatherCode: String,
    @SerializedName("weatherDesc") val weatherDesc: List<WeatherDesc>,
    @SerializedName("weatherIconUrl") val weatherIconUrl: List<WeatherIconUrl>,
    @SerializedName("winddir16Point") val winddir16Point: String,
    @SerializedName("winddirDegree") val winddirDegree: String,
    @SerializedName("windspeedKmph") val windspeedKmph: String,
    @SerializedName("windspeedMiles") val windspeedMiles: String
)
