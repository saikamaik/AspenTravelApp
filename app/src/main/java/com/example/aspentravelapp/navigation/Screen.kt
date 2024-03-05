package com.example.aspentravelapp.navigation

sealed class Screen(
    val route: String
) {
    object Launch: Screen(
        route = "launch_screen"
    )
    object Home: Screen(
        route = "home_screen"
    )
    object ItemInfo: Screen(
        route = "item-info_screen/"
    )
}
