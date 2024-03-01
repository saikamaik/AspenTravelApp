package com.example.aspentravelapp.di

import android.content.Context
import com.example.aspentravelapp.App
import com.example.aspentravelapp.data.LocationRepositoryImpl
import com.example.aspentravelapp.domain.LocationRepository
import com.example.aspentravelapp.useCase.GetLocation
import com.example.aspentravelapp.useCase.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContext(app: App): Context = app.applicationContext

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