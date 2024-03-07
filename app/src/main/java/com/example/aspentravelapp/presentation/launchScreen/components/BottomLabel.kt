package com.example.aspentravelapp.presentation.launchScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.aspentravelapp.R
import com.example.aspentravelapp.navigation.Screen
import com.example.aspentravelapp.ui.theme.Teal
import com.example.aspentravelapp.ui.theme.Typography

@Composable
fun BottomLabel(
    modifier: Modifier,
    buttonModifier: Modifier,
    navController: NavHostController
) {

    Column(
        modifier = modifier
    ) {
        Button(
            onClick = {
                navController.navigate(Screen.Home.route)
            },
            buttonModifier,
            colors = ButtonDefaults.buttonColors(
                Teal
            )
        ) {
            Text(
                text = stringResource(id = R.string.explore),
                style = Typography.bodyLarge
            )
        }
    }
}