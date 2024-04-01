package com.app.weatherapplication.presentation.cityListScreen.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.app.weatherapplication.data.entity.City
import com.app.weatherapplication.databinding.FragmentCityListBinding
import com.app.weatherapplication.presentation.cityListScreen.adapter.CityAdapter
import com.app.weatherapplication.presentation.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CityListFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentCityListBinding

    private lateinit var adapter: CityAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCityListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObserver()
        initButtonListener()

    }

    private fun initButtonListener() {
        binding.addButton.setOnClickListener {
            val cityName = binding.cityNameEdittext.text.toString()
            if (cityName.isEmpty()) return@setOnClickListener
            viewModel.addCity(cityName)
        }
    }

    private fun initObserver() {
        viewModel.getCityList().observe(viewLifecycleOwner) {
            initAdapter(it)
        }
    }

    private fun initAdapter(cityList: List<City>) {
        adapter = CityAdapter(object : CityAdapter.CityListener {
            override fun selectedCity(city: City) {
                viewModel.getWeatherData(city.cityName)
                findNavController().popBackStack()
            }

            override fun deleteCity(city: City) {
                viewModel.deleteCity(city)
            }
        })
        binding.cityListRecyclerView.adapter = adapter
        adapter.submitList(cityList)


    }

    companion object {
        fun newInstance() =
            CityListFragment()
    }
}