package com.jayhalani.quotifycompose.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.jayhalani.quotifycompose.ui.theme.AppStrings

sealed class BottomNavigationItems(
    val route: String,
    val title: String,
    val icon: ImageVector
) {

    data object Home : BottomNavigationItems(
        route = AppStrings.ROUTE_HOME,
        title = "Home",
        icon = Icons.Default.Home
    )

    data object Explore : BottomNavigationItems(
        route = AppStrings.ROUTE_EXPLORE,
        title = "Explore",
        icon = Icons.Default.Explore
    )

    data object Saved : BottomNavigationItems(
        route = AppStrings.ROUTE_SAVED,
        title = "Saved",
        icon = Icons.Default.Favorite
    )
}