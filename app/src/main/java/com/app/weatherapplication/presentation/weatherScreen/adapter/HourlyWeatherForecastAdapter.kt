package com.app.weatherapplication.presentation.weatherScreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.app.weatherapplication.core.utils.convertToNormalTimeFormat
import com.app.weatherapplication.data.model.Hourly
import com.app.weatherapplication.databinding.WeatherForecastHourlyListItemBinding

class HourlyWeatherForecastAdapter :
    ListAdapter<Hourly, HourlyWeatherForecastAdapter.HourlyWeatherForecastViewHolder>(
        HourlyWeatherForecastDiffUtil
    ) {

    private lateinit var binding: WeatherForecastHourlyListItemBinding


    class HourlyWeatherForecastViewHolder(private val binding: WeatherForecastHourlyListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(weather: Hourly) {
            binding.apply {
                hourText.text = weather.time.convertToNormalTimeFormat()
                hourlyTemperatureIcon.load(weather.weatherIconUrl.first().value)
                hourlyTemperature.text = "${weather.tempC}°"
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HourlyWeatherForecastViewHolder {
        binding = WeatherForecastHourlyListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HourlyWeatherForecastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HourlyWeatherForecastViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object HourlyWeatherForecastDiffUtil : DiffUtil.ItemCallback<Hourly>() {
        override fun areItemsTheSame(oldItem: Hourly, newItem: Hourly): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Hourly, newItem: Hourly): Boolean {
            return oldItem.time == newItem.time
        }

    }

}
