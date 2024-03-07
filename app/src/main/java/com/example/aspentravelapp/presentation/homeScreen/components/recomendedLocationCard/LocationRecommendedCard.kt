package com.example.aspentravelapp.presentation.homeScreen.components.recomendedLocationCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.R
import com.example.aspentravelapp.model.Location
import com.example.aspentravelapp.ui.theme.GreenGray
import com.example.aspentravelapp.ui.theme.Typography

@Composable
fun LocationRecommendedCard(
    location: Location,
    contentDescription: String = ""
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Box(
            modifier = Modifier
                .width(175.dp)
                .padding(4.dp)
        ) {
            Column(
                modifier = Modifier.align(Alignment.TopCenter)
            ) {
                Box(
                ) {
                    Image(
                        painter = painterResource(id = location.paintRes),
                        contentDescription = contentDescription,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .sizeIn(maxWidth = 166.dp, maxHeight = 96.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Column(
                        modifier = Modifier.align(Alignment.BottomStart)
                    ) {
                        Text(                   // Название локации
                            text = location.name,
                            style = Typography.bodySmall,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.padding(top = 6.dp)
                        )
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.arrow_up),
                                contentDescription = "",
                                Modifier
                                    .size(15.dp)
                                    .padding(end = 2.dp)
                            )
                            Text(
                                text = "Hot Deal",
                                style = Typography.titleSmall
                            )
                        }
                    }
                    Text(
                        text = location.days!!,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        style = Typography.titleSmall,
                        modifier = Modifier
                            .wrapContentSize(unbounded = true, align = Alignment.BottomEnd)
                            .align(Alignment.BottomEnd)
                            .padding(
                                end = 12.dp,
                                top = painterResource(id = location.paintRes).intrinsicSize.height.dp,
                                bottom = 20.dp
                            )
                            .background(
                                Color.White, shape = RoundedCornerShape(50)
                            )
                            .padding(2.dp)
                            .background(
                                GreenGray, shape = RoundedCornerShape(50)
                            )
                            .padding(3.dp)
                    )
                }
            }
        }
    }
}
