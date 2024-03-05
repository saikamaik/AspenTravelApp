package com.example.aspentravelapp.homeScreen.uistate

import androidx.compose.ui.unit.IntSize
import com.example.aspentravelapp.model.City
import com.example.aspentravelapp.model.Location

data class HomeUiState(
    var location: List<Location> = listOf(),
    var selectedLocation: String = "Aspen",
    var selectedTabOption: String = "Location",
    var selectedItem: String = "Aspen, USA",
    var imageSize: IntSize = IntSize.Zero,

    var searchText: String = "",
    var isDropDownMenuExpanded: Boolean = false,
    var matchedCities: List<City> = listOf(),
    var isSearching: Boolean = false
)