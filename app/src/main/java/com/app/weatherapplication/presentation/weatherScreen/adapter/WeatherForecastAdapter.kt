package com.app.weatherapplication.presentation.weatherScreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.weatherapplication.core.utils.toCustomDateFormat
import com.app.weatherapplication.data.model.Weather
import com.app.weatherapplication.databinding.WeatherForecastListItemBinding

class WeatherForecastAdapter :
    ListAdapter<Weather, WeatherForecastAdapter.WeatherForecastViewHolder>(WeatherForecastDiffUtil) {

    private lateinit var binding: WeatherForecastListItemBinding


    class WeatherForecastViewHolder(private val binding: WeatherForecastListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(weather: Weather) {
            binding.dateText.text = weather.date.toCustomDateFormat()
            binding.temperatureText.text = "${weather.maxtempC}° / ${weather.mintempC}°"

            val hourlyWeatherForecastAdapter = HourlyWeatherForecastAdapter()
            binding.hourlyWeatherRecyclerView.adapter = hourlyWeatherForecastAdapter
            binding.hourlyWeatherRecyclerView.layoutManager =
                LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
            hourlyWeatherForecastAdapter.submitList(weather.hourly)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherForecastViewHolder {
        binding = WeatherForecastListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WeatherForecastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherForecastViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object WeatherForecastDiffUtil : DiffUtil.ItemCallback<Weather>() {
        override fun areItemsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Weather, newItem: Weather): Boolean {
            return oldItem.date == newItem.date
        }

    }

}
