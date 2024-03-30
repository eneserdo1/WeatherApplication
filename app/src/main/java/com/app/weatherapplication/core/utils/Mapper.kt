package com.app.weatherapplication.core.utils

interface Mapper<R, D> {
    fun mapFrom(type: R): D
}