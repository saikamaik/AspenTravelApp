package com.example.aspentravelapp.data

import com.example.aspentravelapp.data.remoteDataSource.ApiService
import com.example.aspentravelapp.model.City
import javax.inject.Inject

class CityRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getCity(name: String): List<City> {
        return apiService.getSearchCity(name)
    }

}