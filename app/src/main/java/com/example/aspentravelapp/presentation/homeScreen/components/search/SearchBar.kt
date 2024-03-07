package com.example.aspentravelapp.presentation.homeScreen.components.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.presentation.homeScreen.HomeViewModel
import com.example.aspentravelapp.presentation.homeScreen.uievent.HomeUiEvent
import com.example.aspentravelapp.presentation.homeScreen.uistate.HomeUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    viewModel: HomeViewModel,
    uiState: HomeUiState
) {
    androidx.compose.material3.SearchBar(
        modifier = Modifier
            .padding(top = 25.dp),
        shape = RoundedCornerShape(30.dp),
        query = uiState.searchText,
        onQueryChange = {
            viewModel.postUiEvent(HomeUiEvent.SetTextValue(it))
            viewModel.onSearchTextChanged(it)
        },
        onSearch = {
            viewModel.postUiEvent(HomeUiEvent.ChangeSearchViewActiveState)
        },
        active = uiState.isSearchViewActive,
        onActiveChange = {
            viewModel.postUiEvent(HomeUiEvent.ChangeSearchViewActiveState)
        },
        placeholder = {
            Text(
                text = "Find things to do",
                color = Color.Gray
            )
        },
        leadingIcon = {
            Icon(
                Icons.Filled.Search,
                null,
                tint = Color.Gray
            )
        },
        trailingIcon = {
            Icon(
                Icons.Filled.Clear,
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.clickable {
                    viewModel.postUiEvent(HomeUiEvent.SetTextValue(""))
                }
            )
        }
    ) {
        when {
            uiState.isSearching && uiState.searchText.isNotEmpty() && uiState.matchedCities.isEmpty() -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .size(24.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

            uiState.searchText.isNotEmpty() && uiState.matchedCities.isNotEmpty() -> {
                uiState.matchedCities.forEach {
                    Row {
                        Text(
                            modifier = Modifier
                                .padding(5.dp)
                                .clickable {
                                    viewModel.postUiEvent(HomeUiEvent.ChangeSelectedMenuItem(it.display_name))
                                    viewModel.postUiEvent(HomeUiEvent.ChangeSearchViewActiveState)
                                    viewModel.postUiEvent(HomeUiEvent.SetTextValue(""))
                                },
                            text = it.display_name,
                            color = Color.Black
                        )
                    }
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(1.dp)
                            .padding(top = 1.dp, bottom = 1.dp)
                    )
                }
            }

            !uiState.isSearching && uiState.searchText.isNotEmpty() && uiState.matchedCities.isEmpty() -> {
                NoSearchResults()
            }
        }
    }
}