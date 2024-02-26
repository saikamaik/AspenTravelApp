package com.example.aspentravelapp.launchScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.aspentravelapp.R

@Composable
fun BottomLabel(modifier: Modifier, buttonModifier: Modifier) {

    Column(
        modifier = modifier
    ) {
        Button(
            onClick = {
                /*TODO*/
            },
            buttonModifier,
            colors = ButtonDefaults.buttonColors(
                colorResource(id = R.color.blue)
            )
        ) {
            Text(
                text = stringResource(id = R.string.explore),
                fontSize = 16.sp

            )
        }
    }
}