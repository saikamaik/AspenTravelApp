package com.example.aspentravelapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.aspentravelapp.homeScreen.HomeScreen
import com.example.aspentravelapp.itemInfoScreen.ItemInfoScreen
import com.example.aspentravelapp.launchScreen.LaunchScreen

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Launch.route
    ) {
        composable(Screen.Launch.route) {
            LaunchScreen(
                navigateToHomeScreen = {
                    navController.navigate(Screen.Home.route)
                }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(
                navigateToItemInfo = { id ->
                    navController.navigate(Screen.ItemInfo.route + "/$id")
                }
            )
        }
        composable(
            Screen.ItemInfo.route + "/{id}",
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
            })
        ){
            ItemInfoScreen()
        }
    }
}