package com.example.aspentravelapp.presentation.itemInfoScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aspentravelapp.domain.LocationRepository
import com.example.aspentravelapp.presentation.itemInfoScreen.iteminfoviewmodelevent.ItemInfoViewModelEvent
import com.example.aspentravelapp.presentation.itemInfoScreen.uievent.ItemInfoUiEvent
import com.example.aspentravelapp.presentation.itemInfoScreen.uistate.ItemInfoUiState
import com.example.aspentravelapp.model.Location
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemInfoViewModel @Inject constructor(
    private val locationRepository: LocationRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val argument: Int = savedStateHandle["id"]!!
    var locations: Location? = null

    private val _uiState: MutableStateFlow<ItemInfoUiState> = MutableStateFlow(ItemInfoUiState())
    val uiState: StateFlow<ItemInfoUiState> = _uiState

    private val _vmEvent: MutableSharedFlow<ItemInfoViewModelEvent> = MutableSharedFlow()
    val vmEvent: SharedFlow<ItemInfoViewModelEvent> = _vmEvent

    fun postUiEvent(event: ItemInfoUiEvent) {
        when (event) {
            is ItemInfoUiEvent.OnClick -> onClick()
        }
    }

    private fun onClick() {
        _uiState.value = _uiState.value.copy(isExpanded = !_uiState.value.isExpanded)
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