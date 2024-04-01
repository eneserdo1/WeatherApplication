package com.app.weatherapplication.presentation.cityListScreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.weatherapplication.data.entity.City
import com.app.weatherapplication.databinding.CityListItemBinding

class CityAdapter(val cityListener: CityListener) :
    ListAdapter<City, CityAdapter.CityViewHolder>(
        CityDiffUtil
    ) {

    private lateinit var binding: CityListItemBinding


    inner class CityViewHolder(private val binding: CityListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(city: City) {
            binding.cityName.text = city.cityName
            binding.deleteCityButton.setOnClickListener {
                cityListener.deleteCity(city)
            }
            itemView.setOnClickListener {
                cityListener.selectedCity(city)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CityViewHolder {
        binding = CityListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object CityDiffUtil : DiffUtil.ItemCallback<City>() {
        override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem.cityName == newItem.cityName
        }

    }

    interface CityListener {
        fun selectedCity(city: City)

        fun deleteCity(city: City)
    }

}
