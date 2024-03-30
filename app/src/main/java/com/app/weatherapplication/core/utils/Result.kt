package com.app.weatherapplication.core.utils

sealed class Result<out T> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val message: String?, val throwable: Throwable?) : Result<Nothing>()
    object Loading : Result<Nothing>()
}