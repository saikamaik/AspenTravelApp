package com.example.aspentravelapp.itemInfoScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aspentravelapp.domain.LocationRepository
import com.example.aspentravelapp.model.Location
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemInfoViewModel @Inject constructor(
    private val locationRepository: LocationRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val argument: Int = savedStateHandle["id"]!!
    lateinit var locations: Location
    var expanded by mutableStateOf(false)
    val extraPadding = if (expanded) 4.dp else 0.dp

    fun onClick() {
        expanded = !expanded
    }

    init {
        getOneLocation(id = argument)
    }

    private fun getOneLocation(id: Int) = viewModelScope.launch {
        locationRepository.getOneLocation(id).collect() { response ->
            locations = response
        }
    }
}