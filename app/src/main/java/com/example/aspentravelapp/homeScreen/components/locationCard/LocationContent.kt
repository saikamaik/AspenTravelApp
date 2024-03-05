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
import com.example.aspentravelapp.model.Location
import com.example.aspentravelapp.model.Locations
import com.example.aspentravelapp.model.Type

@Composable
fun LocationContent(
    navigateToItemInfo: (Int) -> Unit,
    locations: Locations
) {
    val popularLocation: MutableList<Location> = mutableListOf()

    LazyRow(
        modifier = Modifier
            .height(240.dp)
            .padding(top = 12.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        for (location in locations) {
            if (location.type == Type.POPULAR)
                popularLocation += location
        }
        items(
            items = popularLocation
        ) { location ->
            ImageCard(
                location = location,
                contentDescription = "",
                navigateToItemInfo = navigateToItemInfo
            )
        }
    }
}