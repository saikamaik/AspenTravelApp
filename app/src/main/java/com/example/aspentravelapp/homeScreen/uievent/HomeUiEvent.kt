package com.example.aspentravelapp.homeScreen.uievent

import androidx.compose.ui.unit.IntSize

sealed class HomeUiEvent {
    data class SetTextValue(val newString: String) : HomeUiEvent()

    data object ExpandDropDownMenu: HomeUiEvent()
    data class ChangeSelectedMenuItem(val item: String): HomeUiEvent()
    data class ChangeSelectedTabOption(val item: String): HomeUiEvent()
    data class ChangeImageSize(val size: IntSize): HomeUiEvent()
    data object ChangeSearchViewActiveState: HomeUiEvent()
}