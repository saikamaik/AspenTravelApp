package com.example.aspentravelapp.launchScreen.components.boxText

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.aspentravelapp.R
import com.example.aspentravelapp.ui.theme.Typography

@Composable
fun BoxLuxuriousText() {
    Box() {
        Text(
            text = stringResource(id = R.string.luxurious),
            style = Typography.labelLarge
        )
    }
}