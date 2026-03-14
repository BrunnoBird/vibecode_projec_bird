package com.example.vibecodeprojecbird.app.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.vibecodeprojecbird.core.navigation.AppBottomBar
import com.example.vibecodeprojecbird.core.navigation.AppDestination
import com.example.vibecodeprojecbird.core.navigation.BottomNavItemId
import com.example.vibecodeprojecbird.feature.home.presentation.HomeScreen
import com.example.vibecodeprojecbird.feature.home.presentation.HomeViewModel

@Composable
fun AppNavHost(
    homeViewModelFactory: @Composable () -> HomeViewModel
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: AppDestination.Home.route
    
    val selectedItemId = when (currentRoute) {
        AppDestination.Search.route -> BottomNavItemId.Search
        AppDestination.Profile.route -> BottomNavItemId.Profile
        else -> BottomNavItemId.Home
    }

    Scaffold(
        bottomBar = {
            AppBottomBar(
                selectedItemId = selectedItemId,
                onItemSelected = { id ->
                    val route = when (id) {
                        BottomNavItemId.Home -> AppDestination.Home.route
                        BottomNavItemId.Search -> AppDestination.Search.route
                        BottomNavItemId.Profile -> AppDestination.Profile.route
                    }
                    navController.navigate(route) {
                        launchSingleTop = true
                        popUpTo(AppDestination.Home.route) { saveState = true }
                        restoreState = true
                    }
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = AppDestination.Home.route
        ) {
            composable(AppDestination.Home.route) {
                HomeScreen(viewModel = homeViewModelFactory())
            }
            composable(AppDestination.Search.route) {
                Box(Modifier.fillMaxSize()) {
                    Text("Search")
                }
            }
            composable(AppDestination.Profile.route) {
                Box(Modifier.fillMaxSize()) {
                    Text("Profile")
                }
            }
        }
    }
}
