package com.jayhalani.quotifycompose.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.jayhalani.quotifycompose.data.QuoteCategory
import com.jayhalani.quotifycompose.data.QuoteCategoryData
import com.jayhalani.quotifycompose.data.QuoteCategoryModel
import com.jayhalani.quotifycompose.data.QuoteData
import com.jayhalani.quotifycompose.data.QuoteModel
import com.jayhalani.quotifycompose.ui.theme.Bold12
import com.jayhalani.quotifycompose.ui.theme.Bold14
import com.jayhalani.quotifycompose.ui.theme.Bold16
import com.jayhalani.quotifycompose.ui.theme.Bold24
import com.jayhalani.quotifycompose.ui.theme.Medium14

@Composable
fun ExploreScreen(
    initialSelectedCategory: String?, showBackButton: Boolean, onBack: () -> Unit
) {
    val categoryList = remember {
        listOf(
            QuoteCategoryModel(
                id = 0,
                name = "All",
                category = QuoteCategory.ALL,
                icon = Icons.Default.Dashboard,
                color = Color(0xFF607D8B)
            )
        ) + QuoteCategoryData.getCategories()
    }
    var selectedCategoryModel by remember {
        mutableStateOf(categoryList.find { it.category.name == initialSelectedCategory } ?: categoryList.first())
    }
    val quoteList = remember { QuoteData.getQuotes() }
    val filteredQuotes = remember(selectedCategoryModel) {
        if (selectedCategoryModel.category == QuoteCategory.ALL) {
            quoteList
        } else {
            quoteList.filter { it.category == selectedCategoryModel.category }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Row(
            modifier = Modifier.padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (showBackButton) {
                Spacer(Modifier.width(8.dp))
                Icon(
                    modifier = Modifier.clickable(onClick = onBack),
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back Navigation"
                )
            }
            Spacer(Modifier.width(4.dp))
            Text(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp, bottom = 4.dp),
                text = "Categories",
                style = MaterialTheme.typography.Bold24,
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                CategorySelectorRow(
                    categories = categoryList, selectedCategory = selectedCategoryModel
                ) { newCategory ->
                    selectedCategoryModel = newCategory
                }
            }

            items(filteredQuotes.size) {
                QuotesCard(filteredQuotes[it], selectedCategoryModel)
            }
        }
    }
}

@Composable
fun CategorySelectorRow(
    categories: List<QuoteCategoryModel>,
    selectedCategory: QuoteCategoryModel?,
    onCategoryClick: (QuoteCategoryModel) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp), contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(categories.size) { index ->
            val category = categories[index]
            val isCurrentlySelected = category == selectedCategory

            CategoryChip(
                label = category.name,
                chipColor = category.color,
                isSelected = isCurrentlySelected,
                onClick = { onCategoryClick(category) })
        }
    }
}

@Composable
fun CategoryChip(
    label: String, chipColor: Color, isSelected: Boolean, onClick: () -> Unit
) {
    Surface(
        modifier = Modifier.clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, if (isSelected) Color.Transparent else Color.Black),
        color = if (isSelected) chipColor else Color.White
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                color = if (isSelected) Color.White else Color.Black,
                style = MaterialTheme.typography.Medium14
            )
        }
    }
}

@Composable
private fun QuotesCard(quote: QuoteModel, quoteCategoryModel: QuoteCategoryModel) {
    var showDetails by remember { mutableStateOf(false) }
    var isFavorite by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp)
            .fillMaxWidth(),
        border = BorderStroke(1.dp, color = Color.Gray),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .clickable {
                    showDetails = !showDetails
                }) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFFDF8F2))
                    .border(1.dp, color = Color.Gray)
                    .padding(all = 20.dp)
            ) {
                Row {
                    CircleShapeComponent(avatar = quote.avatar, circleColor = quoteCategoryModel.color)
                    SpacerWeight1f()
                    Text(
                        quoteCategoryModel.name,
                        style = MaterialTheme.typography.Bold14.copy(color = quoteCategoryModel.color)
                    )
                }
                Spacer(Modifier.height(16.dp))
                Spacer(Modifier.height(8.dp))
                Text(quote.text, style = MaterialTheme.typography.Bold16)
                Spacer(Modifier.height(16.dp))
                Text(
                    quote.author, style = MaterialTheme.typography.Bold12.copy(
                        fontStyle = FontStyle.Italic, color = quoteCategoryModel.color
                    )
                )
                if (showDetails) {
                    Spacer(Modifier.height(16.dp))
                    HorizontalDivider(color = Color.Gray)
                    Spacer(Modifier.height(16.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        CircleShapeIcon(
                            icon = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite",
                            iconTint = Color(0xFF9CA3AF),
                            circleColor = Color(0xFFE5E7EB),
                        ) {
                            isFavorite = !isFavorite
                        }
                        CircleShapeIcon(
                            icon = Icons.Default.Share,
                            contentDescription = "Share",
                            iconTint = Color(0xFF25D365),
                            circleColor = Color(0xFFD1F0D6),
                        ) {

                        }
                        CircleShapeIcon(
                            icon = Icons.Default.Download,
                            contentDescription = "Download",
                            iconTint = quoteCategoryModel.color,
                            circleColor = Color(0xFFF3F4F6),
                        ) {

                        }
                    }
                }
            }
        }

    }
}

@Composable
private fun CircleShapeIcon(
    icon: ImageVector, contentDescription: String, iconTint: Color, circleColor: Color, onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .size(56.dp)
            .clip(CircleShape)
            .clickable(onClick = onClick),
        color = circleColor,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = icon, contentDescription = contentDescription, tint = iconTint)
        }
    }
}

@Composable
private fun CircleShapeComponent(modifier: Modifier = Modifier, avatar: String, circleColor: Color) {
    Surface(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape),
        color = circleColor.copy(alpha = 0.2f),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(avatar, style = MaterialTheme.typography.Bold24)
        }
    }
}

@Composable
private fun RowScope.SpacerWeight1f() {
    Spacer(modifier = Modifier.weight(1f))
}
