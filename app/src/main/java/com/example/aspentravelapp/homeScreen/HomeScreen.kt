package com.example.aspentravelapp.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.aspentravelapp.R
import com.example.aspentravelapp.homeScreen.components.CitiesDropDownMenu
import com.example.aspentravelapp.homeScreen.components.PopularSection
import com.example.aspentravelapp.homeScreen.components.RecommendedSection
import com.example.aspentravelapp.homeScreen.components.search.SearchBarUI
import com.example.aspentravelapp.homeScreen.components.tabs.TabButtonBar
import com.example.aspentravelapp.homeScreen.uievent.HomeUiEvent
import com.example.aspentravelapp.launchScreen.components.boxText.BoxGradient
import com.example.aspentravelapp.ui.theme.Typography

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    val labels = listOf(
        "Location", "Hotels", "Food", "Adventure", "Adventure2"
    )

    Box(
        Modifier
            .background(Color.White)
            .onGloballyPositioned {
                viewModel.postUiEvent(HomeUiEvent.ChangeImageSize(it.size))
            }
    ) {
        BoxGradient(image = uiState.imageSize)
        Column(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 40.dp
                )
                .verticalScroll(
                    rememberScrollState()
                )
        ) {
            Row(
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = stringResource(id = R.string.explore),
                    style = Typography.bodyMedium
                )
                Spacer(Modifier.weight(1f))
                CitiesDropDownMenu(
                    uiState, viewModel
                )
            }
            Text(
                text = uiState.selectedLocation.substringBefore(","),
                style = Typography.labelMedium
            )
            SearchBarUI(viewModel = viewModel,
                uiState = uiState)
            TabButtonBar(
                labels = labels,
                selectedOption = uiState.selectedTabOption,
                viewModel
            )
            PopularSection(
                locations = uiState.location,
                navHostController = navHostController
            )
            RecommendedSection(
                locations = uiState.location
            )
        }
    }
}