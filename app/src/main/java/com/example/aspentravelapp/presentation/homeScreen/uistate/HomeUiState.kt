package com.example.aspentravelapp.presentation.homeScreen.uistate

import androidx.compose.ui.unit.IntSize
import com.example.aspentravelapp.model.City
import com.example.aspentravelapp.model.Location

data class HomeUiState(
    val location: List<Location> = listOf(),
    val selectedLocation: String = "Aspen",
    val selectedTabOption: String = "Location",
    val selectedItem: String = "Aspen, USA",
    val imageSize: IntSize = IntSize.Zero,
    val isItemLiked: Boolean = false,

    val searchText: String = "",
    val isDropDownMenuExpanded: Boolean = false,
    val matchedCities: List<City> = listOf(),
    val isSearching: Boolean = false,
    val isSearchViewActive: Boolean = false
)