package com.example.aspentravelapp.data.remoteDataSource

import com.example.aspentravelapp.model.City
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search.php?format=jsonv2")
    suspend fun getSearchCity(
        @Query("q") name: String
    ): List<City>

}