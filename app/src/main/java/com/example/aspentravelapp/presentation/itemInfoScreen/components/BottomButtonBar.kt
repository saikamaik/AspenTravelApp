package com.example.aspentravelapp.presentation.itemInfoScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.R
import com.example.aspentravelapp.model.Location
import com.example.aspentravelapp.ui.theme.LightGreen
import com.example.aspentravelapp.ui.theme.Teal
import com.example.aspentravelapp.ui.theme.Typography

@Composable
fun BottomButtonBar(
    modifier: Modifier,
    location: Location
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {

        Column( //Цена
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(id = R.string.price),
                style = Typography.bodySmall,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = location.price.toString() + "$",
                color = LightGreen,
                style = Typography.labelSmall,
                fontWeight = FontWeight.Bold
            )
        }
        Button( //Кнопка Book Now
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                Teal
            ),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier.weight(2f)

        ) {
            Text(
                text = "Book Now",
                style = Typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 9.dp, bottom = 9.dp, end = 10.dp)
            )
            Icon(
                painter = painterResource(
                    id = R.drawable.arror_right
                ),
                contentDescription = "",
                tint = Color.White
            )
        }
    }

}