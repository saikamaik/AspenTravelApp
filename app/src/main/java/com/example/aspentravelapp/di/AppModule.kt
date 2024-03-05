package com.example.aspentravelapp.di

import com.example.aspentravelapp.data.LocationRepositoryImpl
import com.example.aspentravelapp.data.remoteDataSource.ApiService
import com.example.aspentravelapp.domain.LocationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://nominatim.openstreetmap.org/"
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideLocationRepository(
    ): LocationRepository = LocationRepositoryImpl()

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideMainService(retrofit : Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }
}