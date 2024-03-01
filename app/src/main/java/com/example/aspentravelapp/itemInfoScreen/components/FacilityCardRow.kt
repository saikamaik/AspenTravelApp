package com.example.aspentravelapp.itemInfoScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.model.Facilities

@Composable
fun FacilityCardRow(
    facilities: Facilities
) {

    LazyRow(
        modifier = Modifier
            .padding(top = 14.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(
            items = facilities
        ) { facility ->
            FacilityCard(
                facilityName = facility.name,
                facilityAmount = facility.amount
            )
        }
    }

}