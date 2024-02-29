package com.example.aspentravelapp.di

import com.example.aspentravelapp.data.LocationRepositoryImpl
import com.example.aspentravelapp.domain.LocationRepository
import com.example.aspentravelapp.useCase.GetLocation
import com.example.aspentravelapp.useCase.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideLocationRepository(
    ): LocationRepository = LocationRepositoryImpl()

    @Provides
    fun provideUseCases(
        locationRepository: LocationRepository
    ) = UseCases(
        getLocation = GetLocation(locationRepository)
    )

}