package com.example.vibecodeprojecbird.core.navigation

sealed class AppDestination(val route: String) {
    data object Home : AppDestination("home")
    data object Search : AppDestination("search")
    data object Profile : AppDestination("profile")
}
