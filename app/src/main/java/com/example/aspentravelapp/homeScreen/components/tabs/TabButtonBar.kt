package com.example.aspentravelapp.homeScreen.components.tabs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.ui.theme.LightTeal
import com.example.aspentravelapp.ui.theme.Teal

@Composable
fun TabButtonBar(
    labels: List<String>,
    selectedOption: String,
    onSelectionChange: (String) -> Unit
) {

    Row( // Tab'ы
        modifier = Modifier
            .horizontalScroll(
                rememberScrollState()
            )
    ) {
        labels.forEach { text ->
            TabButton(
                text = text,
                onClick = {
                    onSelectionChange(text)
                },
                modifier = Modifier
                    .clickable {
                        onSelectionChange(text)
                    }
                    .padding(end = 2.dp),
                color = if (text == selectedOption) {
                    LightTeal
                } else {
                    Color.Transparent
                },
                textColor = if (text == selectedOption) {
                    Teal
                } else {
                    Color.Gray
                },
                fontWeight = if (text == selectedOption) {
                    FontWeight.Bold
                } else {
                    FontWeight.Normal
                }
            )
        }
    }

}