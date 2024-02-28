package com.example.aspentravelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.aspentravelapp.navigation.Navigation
import com.example.aspentravelapp.ui.theme.AspenTravelAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AspenTravelAppTheme {
                navController = rememberNavController()
                Navigation(navController)
            }
        }
    }
}