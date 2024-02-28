package com.example.aspentravelapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.aspentravelapp.R

val fontHiatusFamily = FontFamily(
    Font(R.font.hiatus, FontWeight.Normal)
)

val fontFamilyMontserrat = FontFamily(
    Font(R.font.montserrat_regular, FontWeight.Normal)
)

val Typography = Typography(

    labelLarge = TextStyle(
        fontFamily = fontFamilyMontserrat,
        fontSize = 40.sp,
        textAlign = TextAlign.Center,
        color = Color.White
    ),
    labelMedium = TextStyle(
        fontFamily = fontFamilyMontserrat,
        fontSize = 32.sp
    ),
    labelSmall = TextStyle(
        fontFamily = fontFamilyMontserrat,
        fontSize = 24.sp
    ),
    titleMedium = TextStyle(
        fontFamily =  fontFamilyMontserrat,
        fontSize = 18.sp
    ),
    titleSmall = TextStyle(
        fontFamily = fontFamilyMontserrat,
        fontSize = 10.sp
    ),
    bodyLarge = TextStyle(
        fontFamily =  fontFamilyMontserrat,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = fontFamilyMontserrat,
        fontSize = 14.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = fontFamilyMontserrat,
        fontSize = 12.sp
    )
)

