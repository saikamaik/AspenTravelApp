package com.example.aspentravelapp.homeScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.aspentravelapp.homeScreen.components.locationCard.LocationContent
import com.example.aspentravelapp.model.Locations
import com.example.aspentravelapp.ui.theme.Teal
import com.example.aspentravelapp.ui.theme.Typography

@Composable
fun PopularSection(
    navHostController: NavHostController,
    locations: Locations
) {

    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier.padding(top = 32.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable (
                    interactionSource = interactionSource,
                    null // Чтобы не было clickable эффекта
                ){

                }
                .fillMaxWidth()
        ) {
            Text(
                text = "Popular",
                style = Typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = "See all",
                style = Typography.bodySmall,
                color = Teal,
            )
        }
        LocationContent(
            locations = locations,
            navHostController = navHostController
        )
    }
}