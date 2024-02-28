package com.example.aspentravelapp.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.aspentravelapp.R
import com.example.aspentravelapp.homeScreen.components.CitiesDropDownMenu
import com.example.aspentravelapp.homeScreen.components.PopularSection
import com.example.aspentravelapp.homeScreen.components.RecommendedSection
import com.example.aspentravelapp.homeScreen.components.search.Search
import com.example.aspentravelapp.homeScreen.components.tabs.TabButtonBar
import com.example.aspentravelapp.launchScreen.components.boxText.BoxGradient
import com.example.aspentravelapp.model.Location
import com.example.aspentravelapp.ui.theme.Typography

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val labels = listOf(
        "Location", "Hotels", "Food", "Adventure", "Adventure2"
    )
    var selectedOption by remember {
        mutableStateOf("Location")
    }

    fun onSelectionChange() = { text: String ->
        selectedOption = text
    }

    var image by remember {
        mutableStateOf(IntSize.Zero)
    }

// Потом можно добавить поле type в location чтобы был фулл список всех локаций
// но выбиралось по типу
    val locations: List<Location> = listOf(
        Location(
            id = 0,
            name = "Alley Palace",
            description = "test1",
            null,
            price = null,
            rating = "4.1",
            paintRes = painterResource(id = R.drawable.imgfirst_background),
            null
        ),
        Location(
            id = 1,
            name = "Coeurdes Alpes",
            description = "test2",
            null,
            price = null,
            rating = "4.5",
            paintRes = painterResource(id = R.drawable.imgsec_background),
            null
        )
    )

    val recLocations: List<Location> = listOf(
        Location(
            id = 0,
            name = "Explore Aspen",
            description = "test1",
            null,
            price = null,
            rating = "4.1",
            paintRes = painterResource(id = R.drawable.location_rec_first_background),
            "4N/5D"
        ),
        Location(
            id = 1,
            name = "Luxurious Aspen",
            description = "test2",
            null,
            price = null,
            rating = "4.5",
            paintRes = painterResource(id = R.drawable.location_rec_second_backbround),
            "2N/3D"
        )
    )

    fun onClickMenuItem(locationName: String) {
        locationName.substringBefore(",")

    }

    Box(
        Modifier
            .background(Color.White)
            .onGloballyPositioned {
                image = it.size
            }
    ) {
        BoxGradient(image = image)
        Column(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 40.dp
                )
                .verticalScroll(
                    rememberScrollState()
                ) //TODO скролл но серч вью + топ бар не пропадают
        ) {
            Row(
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = stringResource(id = R.string.explore),
                    style = Typography.bodyMedium
                )
                Spacer(Modifier.weight(1f))
                CitiesDropDownMenu() //todo сделать чтобы менялось название на главном экране
            }
            Text(
                text = stringResource(id = R.string.Aspen),
                style = Typography.labelMedium
            )
            Search(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            )
            Spacer(modifier = Modifier.weight(4f))
            TabButtonBar(
                labels = labels,
                selectedOption = selectedOption,
                onSelectionChange()
            )
            PopularSection(locations = locations, navHostController = navHostController)
            RecommendedSection(locations = recLocations)
        }
    }
}