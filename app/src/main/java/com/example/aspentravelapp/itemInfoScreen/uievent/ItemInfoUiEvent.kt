package com.example.aspentravelapp.itemInfoScreen.uievent

sealed class ItemInfoUiEvent {
    data object OnClick : ItemInfoUiEvent()
}