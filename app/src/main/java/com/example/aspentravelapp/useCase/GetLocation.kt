package com.example.aspentravelapp.useCase

import com.example.aspentravelapp.domain.LocationRepository

class GetLocation(
    private val repository: LocationRepository
) {
    operator fun invoke() = repository.getAllLocations()
}