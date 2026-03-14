package com.example.vibecodeprojecbird.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavItemId {
    Home,
    Search,
    Profile
}

data class BottomNavItem(
    val id: BottomNavItemId,
    val label: String,
    val icon: ImageVector
)

object BottomNavItems {
    val default: List<BottomNavItem> = listOf(
        BottomNavItem(
            id = BottomNavItemId.Home,
            label = "Home",
            icon = Icons.Filled.Home
        ),
        BottomNavItem(
            id = BottomNavItemId.Search,
            label = "Search",
            icon = Icons.Filled.Search
        ),
        BottomNavItem(
            id = BottomNavItemId.Profile,
            label = "Profile",
            icon = Icons.Filled.Person
        )
    )
}
