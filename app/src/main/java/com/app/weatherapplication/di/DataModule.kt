package com.app.weatherapplication.di

import com.app.weatherapplication.core.utils.NetworkHelper
import com.app.weatherapplication.data.api.ApiService
import com.app.weatherapplication.data.remoteDataSource.RemoteDataSource
import com.app.weatherapplication.data.remoteDataSource.RemoteDataSourceImpl
import com.app.weatherapplication.data.repository.Repository
import com.app.weatherapplication.domain.mapper.WeatherMapper
import com.app.weatherapplication.domain.useCase.WeatherUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun provideDispatchers(dispatcherImpl: DispatcherImpl): DispatcherProvider

    companion object {


        @Singleton
        @Provides
        fun provideApiService(retrofit: Retrofit): ApiService =
            retrofit.create(ApiService::class.java)

        @Singleton
        @Provides
        fun provideRemoteDataSource(
            apiService: ApiService,
            networkHelper: NetworkHelper,
            dispatcherProvider: DispatcherProvider
        ): RemoteDataSource {
            return RemoteDataSourceImpl(apiService, networkHelper, dispatcherProvider)
        }

        @Singleton
        @Provides
        fun provideRepository(remoteDataSource: RemoteDataSource): Repository {
            return Repository(remoteDataSource)
        }

        @Singleton
        @Provides
        fun provideUserUseCase(repository: Repository, mapper: WeatherMapper): WeatherUseCase {
            return WeatherUseCase(repository, mapper)
        }
    }
}