package com.example.aspentravelapp.homeScreen.components.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.homeScreen.HomeViewModel
import com.example.aspentravelapp.homeScreen.uistate.HomeUiState

@Composable
fun SearchBarUI(
    viewModel: HomeViewModel,
    uiState: HomeUiState
) {

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Search(
                viewModel, uiState
            )
            when {
                uiState.isSearching && uiState.searchText.isNotEmpty() && uiState.matchedCities.isEmpty() -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .padding(horizontal = 6.dp)
                            .size(24.dp)
                    )
                }

                uiState.searchText.isNotEmpty() && uiState.matchedCities.isNotEmpty() -> {
                    SearchResults(uiState)
                }

                !uiState.isSearching && uiState.searchText.isNotEmpty() && uiState.matchedCities.isEmpty() -> {
                    NoSearchResults()
                }
            }
        }
    }
}