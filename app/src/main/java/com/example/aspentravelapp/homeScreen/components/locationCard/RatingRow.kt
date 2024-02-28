package com.example.aspentravelapp.homeScreen.components.locationCard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.R
import com.example.aspentravelapp.ui.theme.GreenGray
import com.example.aspentravelapp.ui.theme.Typography
import com.example.aspentravelapp.ui.theme.Yellow

@Composable
fun RatingRow(
    locationRating: String
) {
    Row(
        modifier = Modifier
            .padding(start = 10.dp, top = 6.dp)
            .background(
                GreenGray, shape = RoundedCornerShape(25.dp)
            )
            .padding(start = 10.dp, top = 6.dp, end = 10.dp, bottom = 6.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.star_icon),
            contentDescription = "",
            tint = Yellow,
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = locationRating,
            style = Typography.bodySmall,
            color = Color.White
        )
    }
}