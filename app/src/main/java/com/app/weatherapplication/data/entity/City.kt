package com.app.weatherapplication.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "city_table")
data class City(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "city_name") val cityName: String,
    @ColumnInfo(name = "is_selected") val isSelected: Boolean = false,

    )