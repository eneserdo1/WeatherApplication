package com.app.weatherapplication.core.base

import com.app.weatherapplication.core.utils.AuthError
import com.app.weatherapplication.core.utils.InternetConnectionError
import com.app.weatherapplication.core.utils.NetworkHelper
import com.app.weatherapplication.core.utils.NetworkResource
import com.app.weatherapplication.core.utils.Result
import com.app.weatherapplication.di.DispatcherProvider
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.Response

abstract class BaseRemoteDataSource constructor(
    private val networkHelper: NetworkHelper,
    private val dispatcher: DispatcherProvider
) {
    private suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): NetworkResource<T> {
        return withContext(dispatcher.io) {
            if (networkHelper.isNetworkConnected()) {
                try {
                    val result = apiCall.invoke()
                    when ((result as Response<*>).code()) {
                        in 200..300 -> NetworkResource.Success(result)
                        401 -> NetworkResource.Error(AuthError())
                        else -> NetworkResource.Error(UnknownError())
                    }
                } catch (throwable: Throwable) {
                    NetworkResource.Error(throwable)
                }
            } else {
                NetworkResource.Error(InternetConnectionError())
            }
        }
    }

    fun <T> baseRequestFlow(
        apiCall: suspend () -> Response<T>
    ) = flow {
        emit(Result.Loading)
        val networkResponse = safeApiCall {
            apiCall.invoke()
        }
        val response = when (networkResponse) {
            is NetworkResource.Success -> Result.Success(networkResponse.data!!.body()!!)
            is NetworkResource.Error -> {
                Result.Error(null, networkResponse.throwable)
            }
        }
        emit(response)
    }
}