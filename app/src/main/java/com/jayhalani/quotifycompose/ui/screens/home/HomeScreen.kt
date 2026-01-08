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
import androidx.compose.ui.unit.dp
import com.jayhalani.quotifycompose.data.BannerData
import com.jayhalani.quotifycompose.data.QuoteCategoryData
import com.jayhalani.quotifycompose.data.QuoteData
import com.jayhalani.quotifycompose.ui.screens.home.components.BannerSlider
import com.jayhalani.quotifycompose.ui.screens.home.components.HomeQuotesCard
import com.jayhalani.quotifycompose.ui.screens.home.components.HomeQuotesCategory
import com.jayhalani.quotifycompose.ui.screens.home.components.HomeSectionHeader
import com.jayhalani.quotifycompose.ui.theme.Bold24
import com.jayhalani.quotifycompose.ui.theme.Medium14

@Composable
fun HomeScreen(onNavigateToExplore: (category: String?) -> Unit) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Spacer(modifier = Modifier.padding(top = 12.dp))
            Text(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp, bottom = 4.dp),
                text = "Explore",
                style = MaterialTheme.typography.Bold24,
            )
            Text(
                modifier = Modifier.padding(horizontal = 12.dp),
                text = "Awesome quotes from or community",
                style = MaterialTheme.typography.Medium14.copy(color = Color.Gray),
            )
        }

        item {
            BannerSlider(BannerData.getBanners())
        }

        item {
            HomeSectionHeader(
                startText = "Latest Quotes", endText = "View All", onNavigate = {
                    onNavigateToExplore("All")
                })
        }

        item {
            val randomQuotes = remember {
                QuoteData.getQuotes().shuffled().take(10)
            }

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp), contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(randomQuotes.size) { index ->
                    HomeQuotesCard(quoteModel = randomQuotes[index])
                }
            }
        }

        item {
            HomeSectionHeader(
                startText = "Categories", endText = "View All", onNavigate = {
                    onNavigateToExplore("All")
                })
        }

        item {
            val categories = remember {
                QuoteCategoryData.getCategories()
            }

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp), contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(categories.size) { index ->
                    HomeQuotesCategory(
                        quoteCategory = categories[index],
                        onNavigateToExplore = { selectedCategory ->
                            onNavigateToExplore(selectedCategory)
                        })
                }
            }
        }

        item {
            HomeSectionHeader(
                startText = "Trending Quotes", endText = "View All", onNavigate = {
                    onNavigateToExplore("All")
                })
        }

        item {
            val randomQuotes = remember {
                QuoteData.getQuotes().shuffled().take(10)
            }

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp), contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(randomQuotes.size) { index ->
                    HomeQuotesCard(quoteModel = randomQuotes[index])
                }
            }
        }
    }
}