package com.jayhalani.quotifycompose.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jayhalani.quotifycompose.data.QuoteCategoryData
import com.jayhalani.quotifycompose.data.QuoteData
import com.jayhalani.quotifycompose.ui.screens.home.components.HomeBannerSlider
import com.jayhalani.quotifycompose.ui.screens.home.components.HomeQuotesCard
import com.jayhalani.quotifycompose.ui.screens.home.components.HomeQuotesCategory
import com.jayhalani.quotifycompose.ui.screens.home.components.HomeSectionHeader
import com.jayhalani.quotifycompose.ui.theme.AppDimens
import com.jayhalani.quotifycompose.ui.theme.AppStrings
import com.jayhalani.quotifycompose.ui.theme.Bold24
import com.jayhalani.quotifycompose.ui.theme.Medium14

@Composable
fun HomeScreen(onNavigateToExplore: (category: String?) -> Unit) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(AppDimens.paddingMedium)
    ) {
        item {
            Spacer(modifier = Modifier.padding(top = AppDimens.paddingMedium))
            Text(
                modifier = Modifier.padding(
                    start = AppDimens.paddingMedium, end = AppDimens.paddingMedium, bottom = AppDimens.paddingSmall
                ),
                text = AppStrings.TITLE_HOME,
                style = MaterialTheme.typography.Bold24,
            )
            Text(
                modifier = Modifier.padding(horizontal = AppDimens.paddingMedium),
                text = AppStrings.DESCRIPTION_HOME,
                style = MaterialTheme.typography.Medium14.copy(color = Color.Gray),
            )
        }

        item {
            HomeBannerSlider()
        }

        item {
            HomeSectionHeader(
                startText = AppStrings.SEC_HEADER_LATEST_QUOTES_HOME,
                endText = AppStrings.END_TEXT_VIEW_ALL_HOME,
                onNavigate = {
                    onNavigateToExplore("All")
                })
        }

        item {
            val randomQuotes = remember {
                QuoteData.getQuotes().shuffled().take(10)
            }

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(AppDimens.paddingMedium),
                contentPadding = PaddingValues(horizontal = AppDimens.paddingMedium)
            ) {
                items(randomQuotes.size) { index ->
                    HomeQuotesCard(quoteModel = randomQuotes[index])
                }
            }
        }

        item {

            HomeSectionHeader(
                startText = AppStrings.SEC_HEADER_CATEGORIES_HOME,
                endText = AppStrings.END_TEXT_VIEW_ALL_HOME,
                onNavigate = {
                    onNavigateToExplore("All")
                })
        }

        item {
            val categories = remember {
                QuoteCategoryData.getCategories()
            }

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(AppDimens.paddingMedium),
                contentPadding = PaddingValues(horizontal = AppDimens.paddingMedium)
            ) {
                items(categories.size) { index ->
                    HomeQuotesCategory(
                        quoteCategory = categories[index], onNavigateToExplore = { selectedCategory ->
                            onNavigateToExplore(selectedCategory)
                        })
                }
            }
        }

        item {
            HomeSectionHeader(
                startText = AppStrings.SEC_HEADER_TRENDING_QUOTES_HOME,
                endText = AppStrings.END_TEXT_VIEW_ALL_HOME,
                onNavigate = {
                    onNavigateToExplore("All")
                })
        }

        item {
            val randomQuotes = remember {
                QuoteData.getQuotes().shuffled().take(10)
            }

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(AppDimens.paddingMedium),
                contentPadding = PaddingValues(horizontal = AppDimens.paddingMedium)
            ) {
                items(randomQuotes.size) { index ->
                    HomeQuotesCard(quoteModel = randomQuotes[index])
                }
            }
        }
    }
}