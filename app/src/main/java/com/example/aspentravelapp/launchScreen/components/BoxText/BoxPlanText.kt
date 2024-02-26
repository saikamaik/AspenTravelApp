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
fun BoxPlanText() {

    Box() {
        Text(
            text = stringResource(id = R.string.plan_your),
            color = Color.Black,
            fontSize = 24.sp,
            style = outlineTextStyle
        )
        Text(
            text = stringResource(id = R.string.plan_your),
            color = Color.White,
            fontSize = 24.sp,
            style = backgroundTextStyle

        )
    }

}