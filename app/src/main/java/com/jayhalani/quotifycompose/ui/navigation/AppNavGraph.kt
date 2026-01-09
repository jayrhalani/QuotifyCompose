package com.jayhalani.quotifycompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jayhalani.quotifycompose.ui.screens.category.CategoryQuotesScreen
import com.jayhalani.quotifycompose.ui.screens.explore.ExploreScreen
import com.jayhalani.quotifycompose.ui.screens.home.HomeScreen
import com.jayhalani.quotifycompose.ui.screens.saved.SavedScreen
import com.jayhalani.quotifycompose.ui.theme.AppStrings

@Composable
fun AppNavGraph(modifier: Modifier, navController: NavHostController) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BottomNavigationItems.Home.route
    ) {

        composable(route = BottomNavigationItems.Home.route) {
            HomeScreen(
                onNavigateToExplore = { category ->
                    val route = if (category != null) {
                        "${AppStrings.ROUTE_CATEGORY_QUOTES}/$category"
                    } else {
                        BottomNavigationItems.Explore.route
                    }
                    navController.navigate(route)
                },
            )
        }

        composable(route = BottomNavigationItems.Explore.route) {
            ExploreScreen()
        }

        composable(
            route = AppStrings.ROUTE_CATEGORY_QUOTES_WITH_PARAMS,
            arguments = listOf(
                navArgument(AppStrings.PARAM_CATEGORY) {
                    type = NavType.StringType
                }
            )
        ) { backstackEntry ->
            val category = backstackEntry.arguments?.getString(AppStrings.PARAM_CATEGORY) ?: AppStrings.CATEGORY_ALL

            CategoryQuotesScreen(
                categoryName = category,
                onBack = { navController.popBackStack() }
            )
        }

        composable(route = BottomNavigationItems.Saved.route) {
            SavedScreen()
        }
    }
}
