package com.jayhalani.quotifycompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jayhalani.quotifycompose.data.BannerData
import com.jayhalani.quotifycompose.data.QuoteCategoryData
import com.jayhalani.quotifycompose.data.QuoteCategoryModel
import com.jayhalani.quotifycompose.data.QuoteData
import com.jayhalani.quotifycompose.data.QuoteModel
import com.jayhalani.quotifycompose.presentation.components.BannerSlider
import com.jayhalani.quotifycompose.ui.theme.Bold24
import com.jayhalani.quotifycompose.ui.theme.Medium12
import com.jayhalani.quotifycompose.ui.theme.Medium14
import com.jayhalani.quotifycompose.ui.theme.Medium16
import com.jayhalani.quotifycompose.ui.theme.Normal12

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
            SectionHeader(
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
                    QuotesCard(quoteModel = randomQuotes[index])
                }
            }
        }

        item {
            SectionHeader(
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
                    QuotesCategoryComponent(
                        quoteCategory = categories[index],
                        onNavigateToExplore = { selectedCategory ->
                            onNavigateToExplore(selectedCategory)
                        })
                }
            }
        }

        item {
            SectionHeader(
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
                    QuotesCard(quoteModel = randomQuotes[index])
                }
            }
        }
    }
}


@Composable
private fun QuotesCategoryComponent(
    modifier: Modifier = Modifier,
    quoteCategory: QuoteCategoryModel,
    onNavigateToExplore: (category: String?) -> Unit
) {
    Card(
        modifier = modifier
            .width(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                onNavigateToExplore(quoteCategory.category.name)
            },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(color = quoteCategory.color.copy(alpha = 0.2f))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Surface(
                modifier = modifier.size(44.dp),
                shape = CircleShape,
                color = quoteCategory.color.copy(alpha = 0.5f)
            ) {
                Icon(
                    imageVector = quoteCategory.icon,
                    contentDescription = "Category Icon",
                    modifier = Modifier
                        .size(44.dp)
                        .padding(8.dp),
                    tint = quoteCategory.color
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = quoteCategory.name, style = MaterialTheme.typography.Medium12
            )
        }
    }
}

@Composable
private fun QuotesCard(modifier: Modifier = Modifier, quoteModel: QuoteModel) {
    Card(
        modifier = modifier
            .width(200.dp)
            .height(240.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Blue, Color.Blue.copy(alpha = 0.4f)
                        ),
                    )
                )
                .padding(20.dp)
        ) {
            Row {
                CircleShapeComponent()
                SpacerWeight1f()
                Icon(
                    Icons.Default.Share, contentDescription = "ic_share", tint = Color.White
                )
                Spacer(Modifier.width(8.dp))
                Icon(
                    Icons.Default.FavoriteBorder,
                    contentDescription = "ic_favorite",
                    tint = Color.White,
                )
            }
            SpacerWeight1f()
            Text(
                text = quoteModel.text,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.Medium16.copy(
                    Color.White,
                    lineHeight = 20.sp,
                ),
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "-${quoteModel.author}", style = MaterialTheme.typography.Normal12.copy(
                    Color.White, lineHeight = 16.sp, fontStyle = FontStyle.Italic
                ), modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
private fun RowScope.SpacerWeight1f() {
    Spacer(modifier = Modifier.weight(1f))
}

@Composable
private fun ColumnScope.SpacerWeight1f() {
    Spacer(modifier = Modifier.weight(1f))
}

@Composable
private fun CircleShapeComponent(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(32.dp)
            .clip(CircleShape), color = Color.White.copy(alpha = 0.5f)
    ) {

    }
}

@Composable
private fun SectionHeader(
    modifier: Modifier = Modifier, startText: String, endText: String, onNavigate: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = startText,
            style = MaterialTheme.typography.Medium16,
        )
        // Spacer(modifier = Modifier.weight(1f)) -> alternate to arrangement for this scenario
        Text(
            text = endText, style = MaterialTheme.typography.Medium16, modifier = Modifier.clickable { onNavigate() })
    }
}