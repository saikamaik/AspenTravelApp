package com.example.aspentravelapp.presentation.homeScreen

import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aspentravelapp.data.CityRepository
import com.example.aspentravelapp.domain.LocationRepository
import com.example.aspentravelapp.model.City
import com.example.aspentravelapp.presentation.homeScreen.uievent.HomeUiEvent
import com.example.aspentravelapp.presentation.homeScreen.uistate.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val locationRepository: LocationRepository,
    private val cityRepository: CityRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    var uiState: StateFlow<HomeUiState> = _uiState

    init {
        getLocation()
    }

    fun postUiEvent(event: HomeUiEvent) {
        when (event) {
            is HomeUiEvent.ExpandDropDownMenu -> expandDropDownMenu()
            is HomeUiEvent.ChangeSelectedMenuItem -> changeSelectedMenuItem(event.item)
            is HomeUiEvent.ChangeSelectedTabOption -> onSelectionChange(event.item)
            is HomeUiEvent.ChangeImageSize -> changeImageSizeValue(event.size)
            is HomeUiEvent.ChangeSearchViewActiveState -> changeSearchViewActiveState()
            is HomeUiEvent.SetTextValue -> setTextValue(event.newString)
            is HomeUiEvent.ChangeLikedStateOfLocation -> changeLikedValueOfLocation(event.id)
        }
    }

    private fun changeLikedValueOfLocation(id: Int) {
        _uiState.value.location[id].isLiked = !_uiState.value.location[id].isLiked
        _uiState.value = _uiState.value.copy(location = _uiState.value.location)
    }

    private fun setTextValue(newString: String) {
        _uiState.value = _uiState.value.copy(searchText = newString)
    }

    private fun changeSearchViewActiveState() {
        _uiState.value = _uiState.value.copy(isSearchViewActive = !_uiState.value.isSearchViewActive)
    }

    private fun changeImageSizeValue(size: IntSize) {
        _uiState.value = _uiState.value.copy(imageSize = size)
    }

    private fun expandDropDownMenu() {
        _uiState.value =
            _uiState.value.copy(isDropDownMenuExpanded = !_uiState.value.isDropDownMenuExpanded)
    }

    private fun changeSelectedMenuItem(item: String) {
        _uiState.value = _uiState.value.copy(selectedLocation = item)
        _uiState.value = _uiState.value.copy(selectedItem = item)
    }

    private fun onSelectionChange(item: String) {
        _uiState.value = _uiState.value.copy(selectedTabOption = item)
    }

    private fun getLocation() = viewModelScope.launch {
        locationRepository.getAllLocations().collect { response ->
            _uiState.value = _uiState.value.copy(location = response)
        }
    }

    private fun getCity(name: String) {
        viewModelScope.launch {
            var searchedCities = listOf<City>()
            cityRepository.getCity(name).asFlow().collect() {
                 searchedCities += it
            }
            _uiState.value = _uiState.value.copy(matchedCities = searchedCities)
            _uiState.value = _uiState.value.copy(isSearching = false)
        }
    }

    fun onSearchTextChanged(changedSearchText: String) {
        _uiState.value = _uiState.value.copy(isSearching = true)
        getCity(changedSearchText)
    }
}

