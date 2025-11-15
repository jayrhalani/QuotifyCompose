package com.jayhalani.quotifycompose.presentation

sealed class QuoteScreen(val route: String) {

    data object Home: QuoteScreen("Home")
    data object Explore: QuoteScreen("Explore")
    data object Saved: QuoteScreen("Saved")
}