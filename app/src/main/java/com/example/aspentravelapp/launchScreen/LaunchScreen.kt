package com.example.aspentravelapp.launchScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.aspentravelapp.R
import com.example.aspentravelapp.launchScreen.components.BottomLabel
import com.example.aspentravelapp.launchScreen.components.BottomText
import com.example.aspentravelapp.launchScreen.components.boxText.BoxGradient
import com.example.aspentravelapp.ui.theme.fontHiatusFamily

@Composable
fun LaunchScreen(
    navHostController: NavHostController
) {

    var image by remember {
        mutableStateOf(IntSize.Zero)
    }

        Box {
            Image(
                painterResource(id = R.drawable.background_image),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                alignment = Alignment.CenterEnd,
                modifier = Modifier.onGloballyPositioned {
                    image = it.size
                }
            )
            BoxGradient(image = image)
            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(vertical = 90.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.Aspen),
                    textAlign = TextAlign.Center,
                    fontSize = 116.sp,
                    fontFamily = fontHiatusFamily,
                    color = Color.White,
                )
            }
            Column (
                modifier = Modifier.align(Alignment.BottomStart)
            ) {
                BottomText(modifier = Modifier
                    .padding(
                        start = 30.dp,
                        bottom = 24.dp
                    )
                )
                BottomLabel(modifier = Modifier,
                    buttonModifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 32.dp,
                            end = 32.dp,
                            bottom = 48.dp,
                            top = 12.dp
                        ), navHostController
                )
            }
        }
    }