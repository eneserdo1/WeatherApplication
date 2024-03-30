package com.app.weatherapplication.core.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.weatherapplication.core.constants.MessageConstants.GENERAL_NETWORK_ERROR_MESSAGE
import com.app.weatherapplication.core.utils.Result

abstract class BaseViewModel : ViewModel() {

    var loading = MutableLiveData<Boolean>()
        protected set

    var error = MutableLiveData<String>()
        protected set

    fun <T> handleResult(result: Result<T>) {
        when (result) {
            is Result.Error -> {
                result.message?.let {
                    error.postValue(it)
                } ?: GENERAL_NETWORK_ERROR_MESSAGE
            }

            is Result.Loading -> {
                loading.postValue(true)
            }

            else -> {}
        }
    }
}