package com.example.aspentravelapp.homeScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.R
import com.example.aspentravelapp.ui.theme.Typography

@Composable
fun CitiesDropDownMenu(
) {

    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember {
        mutableStateOf("Aspen, USA")
    }
    val configuration = LocalConfiguration.current
    val textfieldSize = configuration.screenWidthDp.dp / 2

    val citiesList: List<String> = listOf(
        "Aspen, USA", "Moscow, Russia", "Milano, Italy", "Stockholm, Sweden"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
    ) {
        Row(
            modifier = Modifier
                .clickable {
                    expanded = !expanded
                }
        ) {
            Image(
                painterResource(id = R.drawable.pinpoint_img),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .size(16.dp, 16.dp)
                    .align(Alignment.Bottom)
            )
            Text(
                text = selectedItem,
                style = Typography.bodySmall
            )
            Image(
                painter = painterResource(id = R.drawable.drop_down_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(16.dp)
                    .align(Alignment.Bottom)
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(textfieldSize)
        ) {
            citiesList.forEach { location ->
                DropdownMenuItem(
                    onClick = {
                        selectedItem = location
                        expanded = false
//                        onClickMenuItem(location)
                    },
                    text = {
                        Text(
                            text = location,
                            style = Typography.bodySmall,
                            color = Color.Black
                        )
                    }
                )
            }
        }
    }
}