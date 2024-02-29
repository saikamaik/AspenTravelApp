package com.example.aspentravelapp.homeScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aspentravelapp.domain.LocationRepository
import com.example.aspentravelapp.model.Locations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val locationRepository: LocationRepository
) : ViewModel() {

    var location by mutableStateOf<Locations>(listOf())
    var selectedLocation by mutableStateOf("Aspen") //Текущая локация страницы
    var selectedOption by mutableStateOf("Location") //Выбранный айтем в таб баре
    var image by mutableStateOf(IntSize.Zero)
    var selectedItem by mutableStateOf("Aspen, USA") //Выбранный айтем в выпадающей менюшке городов
    fun onSelectionChange() = { text: String ->
        selectedOption = text
    }

    init {
        getLocation()
    }

    private fun getLocation() = viewModelScope.launch {
        locationRepository.getAllLocations().collect() { response ->
            location = response
        }
    }

    fun changeSelectedMenuItem(item: String) {
        selectedLocation = item
    }
}