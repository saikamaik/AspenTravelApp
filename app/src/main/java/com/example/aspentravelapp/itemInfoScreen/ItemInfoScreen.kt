package com.example.aspentravelapp.itemInfoScreen

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aspentravelapp.R
import com.example.aspentravelapp.model.Location
import com.example.aspentravelapp.ui.theme.AspenTravelAppTheme
import com.example.aspentravelapp.ui.theme.DarkerGray
import com.example.aspentravelapp.ui.theme.Teal
import com.example.aspentravelapp.ui.theme.Typography
import com.example.aspentravelapp.ui.theme.Yellow

@Composable
fun ItemInfoScreen(
) {

    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val location = Location(
        id = 0,
        name = "Alley Palace",
        description = "test1",
        null,
        price = null,
        rating = "4.1",
        paintRes = painterResource(id = R.drawable.imgfirst_background),
        null
    )
    // column - > box - > row -> text -> text -> text -> row -> row
    Box(
        modifier = Modifier
            .width(screenHeight)
            .height(screenHeight)
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.Start)
                    .height(325.dp)
                    .width(screenWidth)
            ) {
                Image(
                    painter = location.paintRes,
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(15.dp))
                )
                FloatingActionButton(
                    onClick = {
                        onBackPressedDispatcher?.onBackPressed()
                    },
                    containerColor = Color.White,
                    contentColor = Teal,
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
            }

            Row {
                Text(
                    text = location.name,
                    style = Typography.labelSmall,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Show map",
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
            }

            Text(
                text = "text"
            )

            TextButton(
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Read more",
                    color = Teal,
                    style = Typography.bodyMedium
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow_down),
                    contentDescription = "",
                    tint = Teal,
                    modifier = Modifier.padding(start = 11.dp)
                )
            }

            Text(
                text = "Facilities",
                style = Typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Row {

            }

            Row {

                Column {

                }

            }

        }

    }
}

@Preview
@Composable
fun ItemScreen() {
    AspenTravelAppTheme {
        ItemInfoScreen()
    }
}