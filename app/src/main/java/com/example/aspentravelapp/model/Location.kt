package com.example.aspentravelapp.model

import com.example.aspentravelapp.R

typealias Locations = List<Location>
enum class Type {
    RECOMMENDED, POPULAR
}

data class Location(
    val id: Int,
    val name: String,
    val description: Int,
    val facilities: List<Facility>?,
    val price: Int,
    val rating: String,
    val reviews: Int,
    val paintRes: Int,
    val days: String?,
    val type: Type
)

object LocationObject {
    fun getAllLocations(): List<Location> {
        return listOf(
            Location(
                id = 0,
                name = "Alley Palace",
                description = R.string.alley_palace_desc, //TODO Пока так, но вообще это стринга с огромным текстом, которая должна лежать на бэке
                listOf(
                    Facility(
                        name = "Heater",
                        1
                    ),
                    Facility(
                        "Tub",
                        3
                    )
                ),
                price = 150,
                rating = "4.1",
                reviews = 355,
                paintRes = R.drawable.imgfirst_background,
                null,
                type = Type.POPULAR
            ),
            Location(
                id = 1,
                name = "Coeurdes Alpes",
                description = R.string.coeur_des_alpes_desc, //TODO Пока так, но вообще это стринга с огромным текстом, которая должна лежать на бэке
                listOf(
                    Facility(
                        "Pool",
                        1
                    )
                ),
                price = 200,
                rating = "4.5",
                reviews = 325,
                paintRes = R.drawable.imgsec_background,
                null,
                type = Type.POPULAR
            ),
            Location(
                id = 3,
                name = "Explore Aspen",
                description = R.string.explore_aspen_desc, //TODO Пока так, но вообще это стринга с огромным текстом, которая должна лежать на бэке
                listOf(
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
                ),
                price = 60,
                rating = "4.1",
                reviews = 12,
                paintRes = R.drawable.location_rec_first_background,
                "4N/5D",
                type = Type.RECOMMENDED
            ),
            Location(
                id = 4,
                name = "Luxurious Aspen",
                description = R.string.luxurious_aspen, //TODO Пока так, но вообще это стринга с огромным текстом, которая должна лежать на бэке
                listOf(),
                price = 100,
                rating = "4.5",
                reviews = 56,
                paintRes = R.drawable.location_rec_second_backbround,
                "2N/3D",
                type = Type.RECOMMENDED
            )
        )
    }

    fun getOneLocation(id: Int): Location? {
        var oneLocation: Location? = null
        for (location in getAllLocations()) {
            if (location.id == id) {
                oneLocation = location
            }
        }
        return oneLocation
    }
}

