package com.example.aspentravelapp.model

import androidx.compose.ui.graphics.painter.Painter

typealias Locations = List<Location>
data class Location(
    val id: Int,
    val name: String,
    val description: String,
    val facilities: List<String>?,
    val price: Float?,
    val rating: String,
    val paintRes: Painter,
    val days: String?
)