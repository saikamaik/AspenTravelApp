package com.example.aspentravelapp.presentation.homeScreen.components.tabs

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.aspentravelapp.ui.theme.Typography

@Composable
fun TabButton(
    text: String,
    color: Color,
    textColor: Color,
    fontWeight: FontWeight,
    onClick: () -> Unit,
    modifier: Modifier
) {

    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )

    ) {
        Text(
            text = text,
            color = textColor,
            fontWeight = fontWeight,
            style = Typography.bodyMedium
        )
    }
}