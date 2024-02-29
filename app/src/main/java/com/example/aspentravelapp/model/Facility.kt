package com.example.aspentravelapp.model

typealias Facilities = List<Facility>
data class Facility(
    val name: String,
    val amount: Int
)

object FacilitiesObject {

    fun getAllFacilities(): Facilities{
        return listOf(
            Facility(
                name = "Heater",
                1
            ),
            Facility(
                name = "Dinner",
                2
            ),
            Facility(
                "Tub",
                3
            ),
            Facility(
                "Pool",
                1
            )
        )
    }

}