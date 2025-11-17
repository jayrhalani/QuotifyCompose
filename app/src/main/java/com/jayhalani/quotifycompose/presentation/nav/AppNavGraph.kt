package com.jayhalani.quotifycompose.presentation.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jayhalani.quotifycompose.presentation.ExploreScreen
import com.jayhalani.quotifycompose.presentation.HomeScreen
import com.jayhalani.quotifycompose.presentation.QuoteScreen
import com.jayhalani.quotifycompose.presentation.SavedScreen

@Composable
fun AppNavGraph(modifier: Modifier, navController: NavHostController) {

    NavHost(modifier = modifier, navController = navController, startDestination = QuoteScreen.Home.route) {

        composable(route = QuoteScreen.Home.route) {
            HomeScreen(
                onNavigateToExplore = { category ->
                    navController.navigate("${QuoteScreen.Explore.route}/$category")
                },
            )
        }
        composable(
            route = "${QuoteScreen.Explore.route}/{category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                    nullable = true
                })
        ) { backstackEntry ->
            val category = backstackEntry.arguments?.getString("category")
            ExploreScreen(category) { updated ->

            }
        }
        composable(route = QuoteScreen.Saved.route) {
            SavedScreen()
        }
    }
}