package com.jayhalani.quotifycompose.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class QuoteScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {

    data object Home : QuoteScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    data object Explore : QuoteScreen(
        route = "explore",
        title = "Explore",
        icon = Icons.Default.Explore
    )

    data object Saved : QuoteScreen(
        route = "saved",
        title = "Saved",
        icon = Icons.Default.Favorite
    )
}