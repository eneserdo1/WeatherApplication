package com.app.weatherapplication.di

import android.content.Context
import androidx.room.Room
import com.app.weatherapplication.core.utils.NetworkHelper
import com.app.weatherapplication.data.api.ApiService
import com.app.weatherapplication.data.dao.CityDao
import com.app.weatherapplication.data.database.CityDatabase
import com.app.weatherapplication.data.remoteDataSource.RemoteDataSource
import com.app.weatherapplication.data.remoteDataSource.RemoteDataSourceImpl
import com.app.weatherapplication.data.repository.Repository
import com.app.weatherapplication.domain.mapper.WeatherMapper
import com.app.weatherapplication.domain.useCase.WeatherUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
        fun provideRepository(remoteDataSource: RemoteDataSource, cityDao: CityDao): Repository {
            return Repository(remoteDataSource, cityDao)
        }

        @Singleton
        @Provides
        fun provideWeatherUseCase(repository: Repository, mapper: WeatherMapper): WeatherUseCase {
            return WeatherUseCase(repository, mapper)
        }

        @Singleton
        @Provides
        fun provideCityDatabase(@ApplicationContext context: Context): CityDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                CityDatabase::class.java,
                "city_database"
            ).build()
        }


        @Singleton
        @Provides
        fun provideDao(db: CityDatabase) = db.cityDao()


    }
}