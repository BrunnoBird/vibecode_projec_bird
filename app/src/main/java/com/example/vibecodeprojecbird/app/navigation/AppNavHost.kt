package com.example.vibecodeprojecbird.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vibecodeprojecbird.core.navigation.AppDestination
import com.example.vibecodeprojecbird.feature.home.presentation.HomeScreen
import com.example.vibecodeprojecbird.feature.home.presentation.HomeViewModel

@Composable
fun AppNavHost(
    homeViewModelFactory: @Composable () -> HomeViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppDestination.Home.route
    ) {
        composable(AppDestination.Home.route) {
            HomeScreen(viewModel = homeViewModelFactory())
        }
    }
}
