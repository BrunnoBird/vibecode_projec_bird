package com.example.vibecodeprojecbird.app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
    var selectedItemId by remember { mutableStateOf(BottomNavItemId.Home) }

    Scaffold(
        bottomBar = {
            AppBottomBar(
                selectedItemId = selectedItemId,
                onItemSelected = { selectedItemId = it }
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
        }
    }
}
