package com.example.aspentravelapp.domain

import com.example.aspentravelapp.model.Location
import com.example.aspentravelapp.model.Locations
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    fun getAllLocations(): Flow<Locations>
    fun getOneLocation(id: Int): Flow<Location>

}