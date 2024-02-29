package com.example.aspentravelapp.data

import com.example.aspentravelapp.domain.LocationRepository
import com.example.aspentravelapp.model.Location
import com.example.aspentravelapp.model.LocationObject
import com.example.aspentravelapp.model.Locations
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocationRepositoryImpl @Inject constructor(): LocationRepository {
    override fun getAllLocations(): Flow<Locations> = callbackFlow {
        coroutineScope {
            val locationsList = LocationObject.getAllLocations()
            trySend(locationsList)
        }
        awaitClose {

        }

    }

    override fun getOneLocation(id: Int): Flow<Location> = callbackFlow {
        coroutineScope {
            val location = LocationObject.getOneLocation(id)
            if (location != null) {
                trySend(location)
            }
        }
        awaitClose {

        }
    }


}