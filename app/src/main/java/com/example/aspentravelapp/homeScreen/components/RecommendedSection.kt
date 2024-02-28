package com.example.aspentravelapp.homeScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.homeScreen.components.recomendedLocationCard.LocationRecommendedContent
import com.example.aspentravelapp.model.Locations
import com.example.aspentravelapp.ui.theme.Typography

@Composable
fun RecommendedSection(
    locations: Locations
) {
    Column(
        modifier = Modifier.padding(top = 32.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Recommended",
                style = Typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }
        LocationRecommendedContent(locations = locations)
    }
}