package com.example.aspentravelapp.launchScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.aspentravelapp.launchScreen.components.boxText.BoxLuxuriousText
import com.example.aspentravelapp.launchScreen.components.boxText.BoxPlanText
import com.example.aspentravelapp.launchScreen.components.boxText.BoxVacationText

@Composable
fun BottomText(modifier: Modifier) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom
    ) {
        BoxPlanText()
        BoxLuxuriousText()
        BoxVacationText()
    }

}