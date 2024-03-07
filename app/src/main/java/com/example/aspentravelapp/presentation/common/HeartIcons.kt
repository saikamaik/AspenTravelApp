package com.example.aspentravelapp.presentation.common

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.aspentravelapp.R

@Composable
fun HeartIcons(
    modifier: Modifier,
    thumbIconLiked: Boolean
) {

    Icon(
        painter = painterResource(
            id = if (thumbIconLiked) {
                R.drawable.heart_icon
            } else {
                R.drawable.unfilled_heart_icon
            }
        ),
        tint = Color.Unspecified,
        contentDescription = "",
        modifier = modifier
    )

}