package com.example.aspentravelapp.launchScreen.components.boxText

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.R
import com.example.aspentravelapp.ui.theme.Typography

@Composable
fun BoxPlanText() {
    Box(
        modifier = Modifier.padding(start = 2.dp)
    ) {
        Text(
            text = stringResource(id = R.string.plan_your),
            style = Typography.labelSmall,
            color = Color.White
        )
    }
}