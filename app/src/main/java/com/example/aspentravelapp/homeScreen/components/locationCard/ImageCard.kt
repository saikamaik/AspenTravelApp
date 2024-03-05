package com.example.aspentravelapp.homeScreen.components.locationCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.itemInfoScreen.HeartIcons
import com.example.aspentravelapp.model.Location
import com.example.aspentravelapp.ui.theme.GreenGray
import com.example.aspentravelapp.ui.theme.Typography

@Composable
fun ImageCard(
    navigateToItemInfo: (Int) -> Unit,
    location: Location,
    contentDescription: String = ""
) {
    var thumbIconLiked by remember {
        mutableStateOf(false)
    }
    val interactionSource = remember { MutableInteractionSource() }

    Card(
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.clickable {
            navigateToItemInfo(location.id)
        }
    ) {
        Box(
            modifier = Modifier
                .height(240.dp)
                .width(180.dp)
        ) {
            Image(
                painter = painterResource(id = location.paintRes),
                contentDescription = contentDescription,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
            ) {
                Column {     // Текст и иконка внизу карты локации
                    Text(                   // Название локации
                        text = location.name,
                        style = Typography.bodySmall,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 10.dp, top = 10.dp, end = 10.dp)
                            .background(
                                GreenGray, shape = RoundedCornerShape(25.dp)
                            )
                            .padding(start = 10.dp, top = 6.dp, end = 10.dp, bottom = 6.dp)
                    )
                    Row {
                        RatingRow(          // Иконка звезды и оценка локации
                            locationRating = location.rating
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        HeartIcons(
                            modifier = Modifier
                            .padding(bottom = 16.dp, end = 16.dp, top = 6.dp)
                            .clickable(
                                interactionSource = interactionSource,
                                null // Чтобы не было clickable эффекта
                            ) {
                                thumbIconLiked = !thumbIconLiked
                            }
                            .size(24.dp),
                            thumbIconLiked = thumbIconLiked
                        )
                    }
                }
            }
        }
    }
}