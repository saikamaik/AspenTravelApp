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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.homeScreen.HomeViewModel
import com.example.aspentravelapp.homeScreen.uistate.HomeUiState
import com.example.aspentravelapp.ui.theme.LightTeal
import com.example.aspentravelapp.ui.theme.Teal
import com.example.aspentravelapp.ui.theme.Typography

@Composable
fun Search(
    viewModel: HomeViewModel,
    uiState: HomeUiState
) {

    val containerColor = LightTeal

    Surface(
        modifier = Modifier
            .padding(bottom = 30.dp, top = 25.dp)
            .height(52.dp),
        color = LightTeal,
        shape = RoundedCornerShape(30.dp)
    ) {
        TextField(
            value = uiState.searchText,
            onValueChange = {

                viewModel.onSearchTextChanged(it)
            },
            textStyle = Typography.bodySmall,
            leadingIcon = {
                Icon(
                    Icons.Filled.Search,
                    null,
                    tint = Color.Gray
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            maxLines = 1,
            singleLine = true,
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