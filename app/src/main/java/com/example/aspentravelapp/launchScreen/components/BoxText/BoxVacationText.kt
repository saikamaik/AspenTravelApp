package com.example.aspentravelapp.launchScreen.components.BoxText

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.aspentravelapp.R
import com.example.aspentravelapp.launchScreen.backgroundTextStyle
import com.example.aspentravelapp.launchScreen.outlineTextStyle

@Composable
fun BoxVacationText() {

    Box() {
        Text(
            text = stringResource(id = R.string.vacation),
            color = Color.Black,
            fontSize = 40.sp,
            style = outlineTextStyle
        )
        Text(
            text = stringResource(id = R.string.vacation),
            color = Color.White,
            fontSize = 40.sp,
            style = backgroundTextStyle

        )
    }
}