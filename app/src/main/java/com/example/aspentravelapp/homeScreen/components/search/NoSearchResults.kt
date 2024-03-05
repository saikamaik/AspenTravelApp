package com.example.aspentravelapp.homeScreen.components.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.ui.theme.Typography

@Composable
fun NoSearchResults() {

    Column(
        modifier = Modifier.fillMaxSize().padding(bottom = 15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "No matches found",
            style = Typography.labelSmall,
            color = Color.Gray
        )
    }
}