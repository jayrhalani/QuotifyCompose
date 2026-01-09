package com.jayhalani.quotifycompose.ui.screens.explore.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import com.jayhalani.quotifycompose.data.QuoteCategoryModel
import com.jayhalani.quotifycompose.ui.theme.AppDimens

@Composable
fun ExploreCategoryChipContainer(
    categories: List<QuoteCategoryModel>,
    selectedCategory: QuoteCategoryModel?,
    onCategoryClick: (QuoteCategoryModel) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(AppDimens.paddingSmall),
        contentPadding = PaddingValues(horizontal = AppDimens.paddingMedium)
    ) {
        items(categories.size) { index ->
            val category = categories[index]
            val isCurrentlySelected = category == selectedCategory

            ExploreCategoryChip(
                label = category.name,
                chipColor = category.color,
                isSelected = isCurrentlySelected,
                onClick = { onCategoryClick(category) })
        }
    }
}