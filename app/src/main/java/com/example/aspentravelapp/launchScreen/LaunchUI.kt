package com.example.aspentravelapp.launchScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aspentravelapp.R
import com.example.aspentravelapp.launchScreen.components.BottomLabel
import com.example.aspentravelapp.launchScreen.components.BottomText
import com.example.aspentravelapp.launchScreen.components.BoxText.BoxLuxuriousText
import com.example.aspentravelapp.launchScreen.components.BoxText.BoxPlanText
import com.example.aspentravelapp.launchScreen.components.BoxText.BoxVacationText

val backgroundTextStyle: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = fontFamilyMontserrat,
            textAlign = TextAlign.Center
        )
    }

val outlineTextStyle: TextStyle
    @Composable
    get() {
        return backgroundTextStyle.copy(
            color = Color.Black,
            drawStyle = Stroke(
                miter = 5f,
                width = 5f,
                join = StrokeJoin.Miter
            )
        )
    }

val fontHiatusFamily = FontFamily(
    Font(R.font.hiatus, FontWeight.Normal)
)

val fontFamilyMontserrat = FontFamily(
    Font(R.font.montserrat_regular, FontWeight.Normal)
)

@Composable
fun LaunchUI() {

        Box {
            Image(
                painterResource(id = R.drawable.background_image),
                contentDescription = null,
                contentScale = ContentScale.FillHeight
            )
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
                    .padding(start = 32.dp, bottom = 24.dp)
                )
                BottomLabel(modifier = Modifier,
                    buttonModifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp, end = 32.dp, bottom = 48.dp, top = 12.dp)
                )
            }
        }
    }