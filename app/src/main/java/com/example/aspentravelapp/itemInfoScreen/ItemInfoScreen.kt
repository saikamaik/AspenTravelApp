package com.example.aspentravelapp.itemInfoScreen

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.aspentravelapp.R
import com.example.aspentravelapp.itemInfoScreen.components.ExpandableText
import com.example.aspentravelapp.ui.theme.DarkerGray
import com.example.aspentravelapp.ui.theme.LightGreen
import com.example.aspentravelapp.ui.theme.Teal
import com.example.aspentravelapp.ui.theme.Typography
import com.example.aspentravelapp.ui.theme.Yellow

@Composable
fun ItemInfoScreen(
    viewModel: ItemInfoViewModel = hiltViewModel()
) {

    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    var interactionSource = remember { MutableInteractionSource() }

    val locations = viewModel.locations
    val location = locations[0]
    // column - > box - > row -> text -> text -> text -> row -> row
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .scrollable(
                    rememberScrollState(), orientation = Orientation.Vertical
                ) //Не скролится???
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.Start)
                    .size(height = screenHeight / 2, width = screenWidth)
            ) {
                Image(
                    painter = painterResource(id = location.paintRes),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp)
                        .clip(RoundedCornerShape(15.dp))
                )
                FloatingActionButton(
                    onClick = {
                        onBackPressedDispatcher?.onBackPressed()
                    },
                    containerColor = Color.White,
                    modifier = Modifier.padding(
                        12.dp
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arror_left),
                        contentDescription = "",
                        tint = Color.Gray,
                        modifier = Modifier
                            .padding(15.dp)
                            .size(10.dp, 15.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.heart_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .wrapContentSize(unbounded = true, align = Alignment.BottomEnd)
                        .align(Alignment.BottomEnd)
                        .padding(
                            end = 12.dp
                        )
                        .size(50.dp)
                )
            }

            Row(
                modifier = Modifier.padding(top = 20.dp)
            ) {
                Text(
                    text = location.name,
                    style = Typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = stringResource(id = R.string.show_map),
                    color = Teal,
                    fontWeight = FontWeight.Bold,
                    style = Typography.bodyMedium,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }

            Row(
                modifier = Modifier.padding(top = 6.dp, bottom = 16.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.star_icon),
                    contentDescription = "",
                    tint = Yellow,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = location.rating,
                    style = Typography.bodySmall,
                    color = DarkerGray
                )
                Text(
                    text = " (" + location.reviews + stringResource(id = R.string.reviews),
                    style = Typography.bodySmall,
                    color = DarkerGray
                )
            }

            ExpandableText( //Разворачиващееся описание айтема
                viewModel = viewModel,
                location = location
            )

            Text(
                text = stringResource(id = R.string.facilities),
                style = Typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp)
            )

            Row {//Facilities

            }

        }
        Row(
            modifier = Modifier
                .padding(20.dp)
                .padding(top = 29.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color.White),
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
                    /*TODO*/
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
}
