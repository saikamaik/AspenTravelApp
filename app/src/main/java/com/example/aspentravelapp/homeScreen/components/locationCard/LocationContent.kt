package com.example.aspentravelapp.homeScreen.components.locationCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.aspentravelapp.model.Locations

@Composable
fun LocationContent(
    navHostController: NavHostController,
    locations: Locations
) {

    LazyRow(
        modifier = Modifier
            .height(240.dp)
            .padding(top = 12.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(
            items = locations
        ) { location ->
            ImageCard(
                location = location,
                contentDescription = "",
                navHostController = navHostController
            )
        }
    }
}