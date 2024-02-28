package com.example.aspentravelapp.homeScreen.components.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.ui.theme.LightTeal
import com.example.aspentravelapp.ui.theme.Teal
import com.example.aspentravelapp.ui.theme.Typography

@Composable
fun Search(
    modifier: Modifier
) {

    val (value, onValueChange) = remember { mutableStateOf("") }

    val containerColor = LightTeal

    val iconColor = remember {
        mutableStateOf(Color.Gray)
    }

    Surface(
        modifier = Modifier
            .padding(bottom = 30.dp, top = 25.dp)
            .height(52.dp),
        color = LightTeal,
        shape = RoundedCornerShape(30.dp)
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = Typography.bodySmall,
            leadingIcon = {
                Icon(
                    Icons.Filled.Search,
                    null,
                    tint = iconColor.value
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    iconColor.value = Color.Gray
                },
            placeholder = {
                Text(
                    text = "Find things to do",
                    color = Color.Gray
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = containerColor,
                unfocusedContainerColor = containerColor,
                disabledContainerColor = containerColor,
                cursorColor = Teal,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )
    }
}