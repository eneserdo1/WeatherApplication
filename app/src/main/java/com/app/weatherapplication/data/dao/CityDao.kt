package com.app.weatherapplication.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.app.weatherapplication.data.entity.City

@Dao
interface CityDao {

    @Query("SELECT * FROM city_table ORDER BY id DESC")
    fun getAllCities(): LiveData<List<City>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(city: City)

    @Delete
    suspend fun delete(city: City)

    @Update
    suspend fun update(city: City)
}