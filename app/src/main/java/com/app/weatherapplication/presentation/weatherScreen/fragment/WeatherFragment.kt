package com.app.weatherapplication.presentation.weatherScreen.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.app.weatherapplication.data.model.Weather
import com.app.weatherapplication.databinding.FragmentWeatherBinding
import com.app.weatherapplication.presentation.main.viewmodel.MainViewModel
import com.app.weatherapplication.presentation.weatherScreen.adapter.WeatherForecastAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentWeatherBinding

    private lateinit var adapter: WeatherForecastAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
    }

    private fun initAdapter(weatherList: List<Weather>) {
        adapter = WeatherForecastAdapter()
        binding.weatherForecastList.adapter = adapter
        adapter.submitList(weatherList)
    }

    private fun initObservers() {
        viewModel.weatherData.observe(viewLifecycleOwner) {
            initAdapter(it.weatherForecast)
            binding.apply {
                cityName.text = it.city
                temperatureText.text = it.currentCondition.tempC + "°C"
                temperatureDescriptionText.text = it.currentCondition.weatherDesc.first().value
            }
        }

        viewModel.loading.observe(viewLifecycleOwner) {

        }

        viewModel.error.observe(viewLifecycleOwner) {

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            WeatherFragment()
    }
}