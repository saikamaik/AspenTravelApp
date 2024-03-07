package com.example.aspentravelapp.presentation.launchScreen.components.boxText

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import com.example.aspentravelapp.ui.theme.Teal33

@Composable
fun BoxGradient(image: IntSize) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                //Градиент снизу экрана
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Teal33
                    ),
                    startY = image.height.toFloat() / 2,
                    endY = image.height.toFloat() * 3
                )
            )
    )
}