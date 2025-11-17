package com.jayhalani.quotifycompose.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jayhalani.quotifycompose.data.QuoteCategoryData
import com.jayhalani.quotifycompose.data.QuoteCategoryModel
import com.jayhalani.quotifycompose.ui.theme.Medium14

@Composable
fun ExploreScreen(
    initialSelectedCategory: String?,
    onCategorySelected: (String) -> Unit = {}
) {
    var selectedCategoryState by remember { mutableStateOf(initialSelectedCategory) }
    val categoryList = remember { QuoteCategoryData.getCategories() }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            CategorySelectorRow(
                categories = categoryList,
                selectedCategory = selectedCategoryState
            ) { newCategory ->
                selectedCategoryState = newCategory
                onCategorySelected(newCategory)
            }
        }

        item{

        }
    }
}

@Composable
fun CategorySelectorRow(
    categories: List<QuoteCategoryModel>,
    selectedCategory: String?,
    onCategoryClick: (String) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(categories.size) { index ->
            val category = categories[index]
            val isCurrentlySelected = category.name == selectedCategory

            CategoryChip(
                label = category.name,
                isSelected = isCurrentlySelected,
                onClick = { onCategoryClick(category.name) }
            )
        }
    }
}

@Composable
fun CategoryChip(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier.clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color.Black),
        color = if (isSelected) Color.Blue else Color.White
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
