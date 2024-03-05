package com.example.aspentravelapp.homeScreen.components.search

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.homeScreen.uistate.HomeUiState

@Composable
fun SearchResults(uiState: HomeUiState) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight / 2)
    ) {
        items(uiState.matchedCities) {
            Row {
                Text(
                    text = it.display_name,
                    modifier = Modifier.padding(2.dp)
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
}